package com.project.bookstore.model

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonManagedReference

@Entity
data class Genre(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String?,
    val description: String?,
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "genre")
    @JsonManagedReference
    val books: List<Book>?
)
{

}
