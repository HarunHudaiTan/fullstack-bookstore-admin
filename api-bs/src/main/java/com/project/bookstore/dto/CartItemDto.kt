package com.project.bookstore.dto

import com.project.bookstore.model.Book

data class CartItemDto(
    val quantity: Int?,
    val book: Book?,
)
