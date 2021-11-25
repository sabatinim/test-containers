package com.kata.testcontainers.infrastructure

import arrow.core.Either
import com.kata.testcontainers.domain.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

abstract class LoadEmployeeTest {

    @Test
    internal fun loadEmployee() {
        val loadEmployees = instance()

        assertThat(loadEmployees()).isEqualTo(
            Either.Right(
                Employees(
                    listOf(
                        Employee(
                            "Marco", "Sabatini", DateOfBirth(5, 3, 1983),
                            EmailAddress("address@email.com")
                        )
                    )
                )
            )
        )
    }

    @Test
    internal fun employeeNotValid() {
        val loadEmployees = wrongInstance()

        assertThat(loadEmployees()).isEqualTo(Either.Left(Error("Error For input string: \"wrong\"")))
    }

    abstract fun instance(): () -> Either<Error, Employees>
    abstract fun wrongInstance(): () -> Either<Error, Employees>
}