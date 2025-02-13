package com.project.bookstore.dto


import com.project.bookstore.model.Publisher
import java.math.BigDecimal
data class BookDto(
    val name:String,
    val translatorName:String,
    val genre:GenreDto?,
    val price: BigDecimal?,
    val publicationDate: String?,
    val pages:Int?,
    val language:String?,
    val stockQuantity:Int?,
    val publisher:PublisherDto?,
    val author: AuthorDto?


    )
