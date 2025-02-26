package com.project.bookstore.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Store(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? ,
    val name:String?,
    val adress:String?,
    val email:String?,
    val phone:String?,
) {
    constructor(name: String, adress: String, email: String, phone: String) : this(
        id=null,
        name=name,
        adress=adress,
        email=email,
        phone=phone
    ) {

    }
}
