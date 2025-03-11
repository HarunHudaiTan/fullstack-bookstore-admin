package com.project.bookstore.dto.request



import com.project.bookstore.model.Author
import com.project.bookstore.model.Genre
import com.project.bookstore.model.Publisher
import java.math.BigDecimal


data class CreateBookRequest(
    val name:String?,
    val translatorName:String?,
    val genre:Genre?,
    val price: BigDecimal?,
    val publicationDate: String?,
    val pages:Int?,
    val language:String?,
    val stockQuantity:Int?,
    val publisher: Publisher?,
    val author:CreateAuthorRequest?


)
