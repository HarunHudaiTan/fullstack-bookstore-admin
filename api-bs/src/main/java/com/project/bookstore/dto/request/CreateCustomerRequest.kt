package com.project.bookstore.dto.request

data class CreateCustomerRequest(
    val firstName: String,
    val lastName: String,
    val shippingAddress: String?,
    val billingAddress: String?,
    val phoneNumber: String?,
) {
}