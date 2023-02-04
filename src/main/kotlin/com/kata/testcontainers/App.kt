package com.kata.testcontainers

import com.kata.testcontainers.domain.Employee
import com.kata.testcontainers.infrastructure.inMemoryLoadEmployees
import com.kata.testcontainers.infrastructure.loadEmployeeFrom
import com.kata.testcontainers.infrastructure.loadEmployeeWith

fun main() {
    val dbLoadEmployees = loadEmployeeWith()
    val fileLoadEmployees = loadEmployeeFrom("/tmp/target/test-classes/employees.txt")
    val inMemLoadEmployees = inMemoryLoadEmployees()

    println("######## DB Employees ########")
    dbLoadEmployees().map { it.employeeGroup.forEach(::print) }

    println("######## File Employees ########")
    fileLoadEmployees().map { it.employeeGroup.forEach(::print) }

    println("######## In Memory Employees ########")
    inMemLoadEmployees().map { it.employeeGroup.forEach(::print) }
}

fun print(e: Employee) {
    println("""First Name: ${e.firstName}""")
    println("""Last Name: ${e.lastName}""")
    println("""Email: ${e.emailAddress}""")
    println("""BirthDay: ${e.dateOfBirth}""")
}