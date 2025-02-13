package com.project.bookstore.model

import jakarta.persistence.*

@Entity
data class Publisher (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String?,
    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val books: Set<Book>?

)