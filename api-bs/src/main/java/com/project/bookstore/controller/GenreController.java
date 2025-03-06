package com.project.bookstore.controller;

import com.project.bookstore.model.Genre;
import com.project.bookstore.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/genre")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.createGenre(genre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable("id") Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable("id") Long id, @RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.updateGenre(id, genre));
    }
} 