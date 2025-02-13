package com.project.bookstore.dto.converter;

import com.project.bookstore.dto.GenreDto;
import com.project.bookstore.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreDtoConverter {

    public GenreDto convert(Genre from) {
      return new GenreDto(from.getName(),from.getDescription());

    }
}
