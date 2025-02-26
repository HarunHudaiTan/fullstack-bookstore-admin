package com.project.bookstore.service;

import com.project.bookstore.dto.BookDto;
import com.project.bookstore.dto.converter.BookDtoConverter;
import com.project.bookstore.dto.request.CreateBookRequest;
import com.project.bookstore.dto.request.IncreaseBookStockRequest;
import com.project.bookstore.dto.request.UpdateBookRequest;
import com.project.bookstore.exception.BookNotFoundException;
import com.project.bookstore.model.Book;
import com.project.bookstore.repository.AuthorRepository;
import com.project.bookstore.repository.BookRepository;
import com.project.bookstore.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;
    private final GenreService genreService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository,
                       BookDtoConverter bookDtoConverter,
                       GenreRepository genreRepository,
                       AuthorRepository authorRepository,
                       PublisherService publisherService, GenreService genreService, AuthorRepository authorRepository1, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
        this.genreService = genreService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    public BookDto addBook(CreateBookRequest request) {
        Book book = new Book(Objects.requireNonNull(request.getName()),
                request.getTranslatorName(),
               genreService.createGenre(request.getGenre()),
                request.getPrice(),
                request.getPublicationDate(),
                request.getPages(),
                request.getLanguage(),
                request.getStockQuantity(),
                publisherService.createPublisher(request.getPublisher()),
                authorService.createAuthor(request.getAuthor()));
        return bookDtoConverter.convert(bookRepository.save(book));
    }

    public BookDto updateBook(Long id, UpdateBookRequest request) {
        Book book = findBookById(id);
        Book updatedBook = new Book(
                book.getId(),
                request.getName(),
                request.getTranslatorName(),
                request.getGenre(),
                request.getPrice(),
                request.getPublicationDate(),
                request.getPages(),
                request.getLanguage(),
                request.getStockQuantity(),
                request.getPublisher(),
                request.getAuthor()
        );
        return bookDtoConverter.convert(bookRepository.save(updatedBook));
    }


    public BookDto getBookById(Long id) {
        return bookDtoConverter.convert(bookRepository.findById(id).get());
    }

    protected Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException("Book not found by id"));
    }

    public List<BookDto> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(bookDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }


}
