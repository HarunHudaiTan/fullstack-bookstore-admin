package com.project.bookstore.dto.request

import com.project.bookstore.model.Role

data class UpdateUserRequest(
    val name: String?,
    val surname: String?,
    val username: String?,
    val shippingAddress: String?,
    val billingAddress: String?,
    val authorities:Set<Role>?,
    val isAccountNonExpired: Boolean?,
    val isAccountNonLocked: Boolean?,
    val isCredentialsNonExpired: Boolean?,
    val isEnabled:Boolean?
    )
