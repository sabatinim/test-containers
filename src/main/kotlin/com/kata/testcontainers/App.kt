package com.kata.testcontainers

import com.kata.testcontainers.infrastructure.loadEmployeeWith

fun main() {
    val employees = loadEmployeeWith()

    println("Employees")
    employees().map { it.employeeGroup.forEach(::println) }
}