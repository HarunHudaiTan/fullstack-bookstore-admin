package com.project.bookstore.model

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class ShoppingCart(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id :Long?,
    val createdDate: LocalDateTime,
    val updatedDate: LocalDateTime,
    @OneToMany(mappedBy = "shoppingCart",fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val cartItems: Set<CartItem>,
    @OneToOne(fetch = FetchType.EAGER,cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id")
    val customer: Customer


    )
