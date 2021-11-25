package com.kata.testcontainers.infrastructure

import arrow.core.Either
import com.kata.testcontainers.domain.Employees
import com.kata.testcontainers.domain.Error
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class FileLoadEmployeeTest : LoadEmployeeTest() {

    override fun instance(): () -> Either<Error, Employees> =
        loadEmployeeFrom("./target/test-classes/employees.txt")

    override fun wrongInstance(): () -> Either<Error, Employees> =
        loadEmployeeFrom("./target/test-classes/employeesNotValid.txt")

    @Test
    internal fun fileNotFound() {

        val loadEmployeeFromFile = loadEmployeeFrom("NOT_EXIXSTING_FILE")

        Assertions.assertThat(loadEmployeeFromFile())
            .isEqualTo(Either.Left(Error("File NOT_EXIXSTING_FILE doesn't exist")))
    }
}