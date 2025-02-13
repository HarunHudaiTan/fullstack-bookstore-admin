package com.project.bookstore.model

import jakarta.persistence.*
import java.math.BigDecimal


@Entity
data class CartItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val quantity: Int,
    @ManyToOne(cascade = [(CascadeType.ALL)],fetch = FetchType.LAZY)
    val book:Book,
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "shopping_cart_id", nullable = false)
    val shoppingCart: ShoppingCart,


    )
