package com.project.bookstore.dto.converter;

import com.project.bookstore.dto.PublisherDto;
import com.project.bookstore.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherDtoConverter {
    public PublisherDto convert(Publisher from) {
        return new PublisherDto(from.getName());
    }
}
