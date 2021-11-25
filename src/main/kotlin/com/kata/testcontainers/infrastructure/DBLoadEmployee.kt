package com.kata.testcontainers.infrastructure

import arrow.core.Either
import com.kata.testcontainers.domain.*
import java.sql.Connection
import java.sql.DriverManager
import java.util.*

fun connection(
    user: String = "root",
    password: String = "pwd",
    host: String = "mysql",
    port: String = "3306"
): Connection {

    val connectionProps =
        Properties().let {
            it["user"] = user
            it["password"] = password
            it
        }

    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()
    return DriverManager.getConnection("""jdbc:mysql://${host}:${port}/birthday""", connectionProps)
}

fun loadEmployeeWith(): () -> Either<Error, Employees> = {
    try {
        val stmt = connection().createStatement()

        val resultSet = stmt!!.executeQuery("SELECT * FROM employees")

        val res = mutableListOf<Employee>()
        while (resultSet.next())
            res.add(
                Employee(
                    resultSet.getString("FirstName"),
                    resultSet.getString("LastName"),
                    dateOfBirth(resultSet.getString("BirthDay")),
                    EmailAddress(resultSet.getString("Email"))
                )
            )

        stmt.close()

        Either.Right(Employees(res))
    } catch (ex: Exception) {
        Either.Left(Error("""Error ${ex.message}"""))
    }
}


