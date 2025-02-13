package com.project.bookstore.controller;

import com.project.bookstore.dto.BookDto;
import com.project.bookstore.dto.request.CreateBookRequest;
import com.project.bookstore.dto.request.IncreaseBookStockRequest;
import com.project.bookstore.dto.request.UpdateBookPriceRequest;
import com.project.bookstore.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody CreateBookRequest request) {
        return ResponseEntity.ok(bookService.addBook(request));
    }

    @PostMapping("/increaseStock/{id}")
    public ResponseEntity<BookDto> increaseBookStock(@PathVariable Long id, IncreaseBookStockRequest request) {
        return ResponseEntity.ok(bookService.increaseBookStock(id, request));
    }
    @PutMapping
    public ResponseEntity<BookDto> updateBookPrice(@PathVariable Long id, UpdateBookPriceRequest request){
        return ResponseEntity.ok(bookService.updateBookPrice(id,request));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping
    public ResponseEntity<BookDto> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }



}
