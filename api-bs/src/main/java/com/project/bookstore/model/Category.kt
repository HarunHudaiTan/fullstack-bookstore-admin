package com.project.bookstore.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Category(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String?,
    val description: String?,

)
