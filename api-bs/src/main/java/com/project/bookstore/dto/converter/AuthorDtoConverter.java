package com.project.bookstore.dto.converter;

import com.project.bookstore.dto.AuthorDto;
import com.project.bookstore.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoConverter {
    public AuthorDto convert(Author from) {
        return new AuthorDto(from.getFirstName(),from.getLastName());
    }
}
