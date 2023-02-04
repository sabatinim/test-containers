package com.kata.testcontainers.infrastructure

import arrow.core.Either
import com.kata.testcontainers.domain.Employees
import com.kata.testcontainers.domain.Error

class InMemoryLoadEmployeeTest : LoadEmployeeTest() {

    override fun instance(): () -> Either<Error, Employees> =
        inMemoryLoadEmployees()

    override fun wrongInstance(): () -> Either<Error, Employees> =
        inMemoryLoadEmployees(true)
}