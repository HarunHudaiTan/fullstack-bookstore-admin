package com.project.bookstore.dto.converter;

import com.project.bookstore.dto.AccountCustomerDto;
import com.project.bookstore.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class AccountCustomerDtoConverter {
    public AccountCustomerDto convert(Customer from) {
        return new AccountCustomerDto(from.getFirstName(), from.getLastName());

    }
}
