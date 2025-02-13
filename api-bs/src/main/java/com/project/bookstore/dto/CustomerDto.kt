package com.project.bookstore.dto

data class CustomerDto(
    val firstName: String,
    val lastName: String?,
    val shippingAddress: String?,
    val billingAddress: String?,
    val phoneNumber: String?,
    val account:Set<CustomerAccountDto>?,

)
