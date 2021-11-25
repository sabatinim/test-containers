package com.kata.testcontainers.infrastructure

import com.kata.testcontainers.domain.DateOfBirth

fun dateOfBirth(birthday: String) =
    DateOfBirth(
        birthday.split("/")[0].toInt(),
        birthday.split("/")[1].toInt(),
        birthday.split("/")[2].toInt()
    )