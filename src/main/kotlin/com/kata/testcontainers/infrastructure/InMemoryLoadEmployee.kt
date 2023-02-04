package com.kata.testcontainers.infrastructure

import arrow.core.Either
import com.kata.testcontainers.domain.DateOfBirth
import com.kata.testcontainers.domain.EmailAddress
import com.kata.testcontainers.domain.Employee
import com.kata.testcontainers.domain.Employees
import com.kata.testcontainers.domain.Error


fun inMemoryLoadEmployees(faulty: Boolean = false): () -> Either<Error, Employees> {

    val inMemoryLoadEmployee: () -> Either<Nothing, Employees> = {
        Either.Right(
            Employees(
                listOf(
                    Employee(
                        "Marco",
                        "Sabatini",
                        DateOfBirth(5, 3, 1983),
                        EmailAddress("address@email.com")
                    )
                )
            )
        )
    }

    if (faulty) {
        return { Either.Left(Error("Error For input string: \"wrong\"")) }
    } else {
        return inMemoryLoadEmployee
    }
}