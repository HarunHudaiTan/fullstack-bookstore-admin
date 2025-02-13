package com.project.bookstore.dto.request

import java.math.BigDecimal

data class UpdateBookPriceRequest(
    var bookPrice: BigDecimal,
)
