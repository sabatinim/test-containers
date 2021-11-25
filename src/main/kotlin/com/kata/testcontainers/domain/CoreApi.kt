package com.kata.testcontainers.domain

data class Employee(
        val firstName: String = "NAME",
        val lastName: String = "LASTNAME",
        val dateOfBirth: DateOfBirth = DateOfBirth(1, 1, 1),
        val emailAddress: EmailAddress = EmailAddress("EMAIL")
)
data class DateOfBirth(val day: Int,val month: Int,val year: Int)
data class EmailAddress(val value: String)
data class Employees(val employeeGroup: List<Employee>)

data class Error(val msg: String)
