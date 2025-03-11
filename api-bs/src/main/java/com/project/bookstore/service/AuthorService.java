package com.project.bookstore.service;


import com.project.bookstore.dto.request.CreateAuthorRequest;
import com.project.bookstore.dto.request.UpdateAuthorRequest;
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
    public Author createAuthor(CreateAuthorRequest request) {
       Author author = new Author(request.getFirstName(),request.getLastName());
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

    public Author updateAuthor(Long id, UpdateAuthorRequest request) {
        Author existingAuthor = getAuthorById(id);
        Author updatedAuthor = new Author(
                existingAuthor.getId(),
                request.getFirstName(),
                request.getLastName(),
                existingAuthor.getBooks()
        );
        return authorRepository.save(updatedAuthor);
    }
}
