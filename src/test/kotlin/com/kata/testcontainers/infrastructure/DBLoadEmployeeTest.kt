package com.kata.testcontainers.infrastructure

import arrow.core.Either
import com.kata.testcontainers.domain.Employees
import com.kata.testcontainers.domain.Error
import org.junit.jupiter.api.AfterEach

class DBLoadEmployeeTest : LoadEmployeeTest() {

    @AfterEach
    fun cleanupTest() {
        execute("DELETE from employees")
    }

    override fun instance(): () -> Either<Error, Employees> {
        execute("INSERT INTO employees VALUES ('Marco', 'Sabatini','05/03/1983','address@email.com')")

        return loadEmployeeWith()
    }

    override fun wrongInstance(): () -> Either<Error, Employees> {
        execute("INSERT INTO employees VALUES ('', '','wrong','')")

        return loadEmployeeWith()
    }

    private fun execute(sql: String) {
        val stmt = connection().createStatement()
        stmt!!.executeUpdate(sql)
        stmt.close()
    }
}