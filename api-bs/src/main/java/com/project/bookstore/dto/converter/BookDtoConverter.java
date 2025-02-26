package com.project.bookstore.dto.converter;

import com.project.bookstore.dto.BookDto;
import com.project.bookstore.model.Book;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BookDtoConverter {

private final AuthorDtoConverter authorDtoConverter;
private final GenreDtoConverter genreDtoConverter;
private final PublisherDtoConverter publisherDtoConverter;
public BookDtoConverter(AuthorDtoConverter authorDtoConverter, GenreDtoConverter genreDtoConverter, PublisherDtoConverter publisherDtoConverter) {
    this.authorDtoConverter = authorDtoConverter;
    this.genreDtoConverter = genreDtoConverter;
    this.publisherDtoConverter = publisherDtoConverter;
}

    public BookDto convert(Book from) {
        return new BookDto((from.getName()),
                (from.getTranslatorName()),
                genreDtoConverter.convert(from.getGenre()),
                from.getPrice(),
                from.getPublicationDate(),
                from.getPages(),
                from.getLanguage(),
                from.getStockQuantity(),
                publisherDtoConverter.convert(from.getPublisher()),
                authorDtoConverter.convert(from.getAuthor()));

    }
}
