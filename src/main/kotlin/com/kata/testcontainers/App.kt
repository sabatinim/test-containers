package com.kata.testcontainers

import com.kata.testcontainers.domain.Employee
import com.kata.testcontainers.infrastructure.loadEmployeeWith

fun main() {
    val employees = loadEmployeeWith()

    println("######## Employees ########")
    employees()
        .map {
            it.employeeGroup.forEach(::print)
        }
}

fun print(e:Employee){
    println("""First Name: ${e.firstName}""")
    println("""Last Name: ${e.lastName}""")
    println("""Email: ${e.emailAddress}""")
    println("""BirthDay: ${e.dateOfBirth}""")
}