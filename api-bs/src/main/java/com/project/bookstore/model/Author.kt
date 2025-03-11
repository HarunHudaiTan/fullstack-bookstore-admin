package com.project.bookstore.model

import jakarta.persistence.*

@Entity
data class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?,
    val firstName:String?,
    val lastName:String?,
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")

    val books: Set<Book>?

) {
    constructor(firstName: String, lastName: String) : this(
        id = null,
        firstName = firstName,
        lastName = lastName,
        books=null
    )


}
