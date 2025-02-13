package com.project.bookstore.service;


import com.project.bookstore.model.Author;
import com.project.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = getAuthorById(id);
        Author updatedAuthor = new Author(
                existingAuthor.getId(),
                author.getFirstName(),
                author.getLastName(),
                existingAuthor.getBooks()
        );
        return authorRepository.save(updatedAuthor);
    }
}
