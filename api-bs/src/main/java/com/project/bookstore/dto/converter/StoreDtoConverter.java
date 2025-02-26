package com.project.bookstore.dto.converter;

import com.project.bookstore.dto.StoreDto;
import com.project.bookstore.model.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreDtoConverter {

    public StoreDto convert(Store from) {
        return new StoreDto(from.getName(),from.getAdress(),from.getEmail(),from.getPhone());
    }


}
