package com.project.bookstore.dto.request

import com.project.bookstore.model.Role

data class CreateUserRequest(
    val name: String,
    val surname: String,
    val username: String,
    val password: String,
    val authorities: Set<Role>
)
