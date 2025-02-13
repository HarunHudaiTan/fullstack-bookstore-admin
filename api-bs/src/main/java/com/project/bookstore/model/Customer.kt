package com.project.bookstore.model

import jakarta.persistence.*


@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val shippingAddress: String?,
    val billingAddress: String?,
    val phoneNumber: String?,


    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
    val shoppingCart: ShoppingCart?
) {
    // Secondary constructor without accounts, orders, and shoppingCart
    constructor(
        firstName: String,
        lastName: String,
        shippingAddress: String?,
        billingAddress: String?,
        phoneNumber: String?
    ) : this(
        id = null,
        firstName = firstName,
        lastName = lastName,
        shippingAddress = shippingAddress,
        billingAddress = billingAddress,
        phoneNumber = phoneNumber,
        shoppingCart = null
    )
}
