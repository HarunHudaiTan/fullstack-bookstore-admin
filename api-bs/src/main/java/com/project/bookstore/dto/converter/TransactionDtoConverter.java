package com.project.bookstore.dto.converter;

import com.project.bookstore.dto.TransactionDto;
import com.project.bookstore.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {


    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getAmount(),
                from.getTransactionDate(),
                from.getTransactionType(),from.getStatus(),
                from.getPaymentMethod(),from.getOrder());
    }
}
