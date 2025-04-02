package com.project.bookstore.dto.request

import com.project.bookstore.model.Author
import com.project.bookstore.model.Publisher
import java.math.BigDecimal

data class UpdateBookRequest(
    val name: String?,
    val translatorName: String?,
    val price: BigDecimal?,
    val publicationDate: String?,
    val pages: Int?,
    val language: String?,
    val stockQuantity: Int?,
    val publisher:Publisher,
    val author:Author

    )