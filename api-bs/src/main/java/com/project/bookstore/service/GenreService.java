package com.project.bookstore.service;


import com.project.bookstore.dto.GenreDto;
import com.project.bookstore.dto.converter.GenreDtoConverter;
import com.project.bookstore.model.Genre;
import com.project.bookstore.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreDtoConverter genreDtoConverter;
    public GenreService(GenreRepository genreRepository, GenreDtoConverter genreDtoConverter) {
        this.genreRepository = genreRepository;
        this.genreDtoConverter = genreDtoConverter;
    }
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    public Genre updateGenre(Long id, Genre genre) {
        Genre existingGenre = getGenreById(id);
        Genre updatedGenre = new Genre(
                existingGenre.getId(),
                genre.getName(),
                genre.getDescription(),
                existingGenre.getBooks()
        );
        return genreRepository.save(updatedGenre);
    }
}
