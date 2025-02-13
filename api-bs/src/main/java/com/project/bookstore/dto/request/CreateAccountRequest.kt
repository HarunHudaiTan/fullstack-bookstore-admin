package com.project.bookstore.dto.request

data class CreateAccountRequest(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val customerId: Long,
    val email: String,
    val password: String,

    )
