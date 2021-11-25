package com.kata.testcontainers.infrastructure

import arrow.core.Either
import com.kata.testcontainers.domain.*
import java.io.File
import java.io.FileNotFoundException

fun loadEmployeeFrom(fileName: String): () -> Either<Error, Employees> = {
    try {
        Either.Right(Employees(File(fileName).bufferedReader().readLines().map { toEmployee(it) }))
    } catch (e: FileNotFoundException) {
        Either.Left(Error("File $fileName doesn't exist"))
    } catch (e: Exception) {
        Either.Left(Error("Error ${e.message}"))
    }
}

private fun toEmployee(row: String): Employee {
    val rowSplitted = row.split(",")
    return Employee(
        rowSplitted[0],
        rowSplitted[1],
        dateOfBirth(rowSplitted[2]),
        EmailAddress(rowSplitted[3])
    )
}
