package com.project.bookstore.dto

data class ShoppingCartDto(
    val cartItems: Set<CartItemDto>?,
    val customer:CustomerDto?
)
