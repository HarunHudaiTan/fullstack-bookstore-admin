package com.project.bookstore.dto.response

data class JwtResponse(
    val accessToken: String,
    val refreshToken: String,
    val tokenType: String = "Bearer ",
    val username: String

)
