package com.project.bookstore.model

import jakarta.persistence.*
import java.math.BigDecimal
import com.fasterxml.jackson.annotation.JsonBackReference

@Entity
data class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String?,
    val translatorName: String?,
    val ISBN: String?,
    @ManyToOne(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    @JsonBackReference
    val genre: Genre?,
    val price: BigDecimal?,
    val publicationDate: String?,
    val pages: Int?,
    val language: String?,
    val stockQuantity: Int?,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "publisher_books")
    val publisher: Publisher?,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    val author: Author?,
    @OneToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    val orderItems: Set<OrderItem>? = HashSet()
) {
    // Secondary constructor
    constructor(
        name: String,
        translatorName: String?,
        genre: Genre?,
        price: BigDecimal?,
        publicationDate: String?,
        pages: Int?,
        language: String?,
        stockQuantity: Int?,
        publisher: Publisher?,
        author: Author?
    ) : this(
        id = null,
        name = name,
        translatorName = translatorName,
        ISBN = null,
        genre = genre,
        price = price,
        publicationDate = publicationDate,
        pages = pages,
        language = language,
        stockQuantity = stockQuantity,
        publisher = publisher,
        author = author
    )
}
