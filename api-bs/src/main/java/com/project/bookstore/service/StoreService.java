package com.project.bookstore.service;

import com.project.bookstore.dto.StoreDto;
import com.project.bookstore.dto.converter.StoreDtoConverter;
import com.project.bookstore.dto.request.CreateStoreRequest;
import com.project.bookstore.dto.request.UpdateStoreRequest;
import com.project.bookstore.model.Store;
import com.project.bookstore.repository.StoreRepository;
import com.project.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final StoreDtoConverter converter;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    public StoreService(StoreRepository storeRepository, StoreDtoConverter converter, UserRepository userRepository) {
        this.storeRepository = storeRepository;
        this.converter = new StoreDtoConverter();
        this.userRepository = userRepository;
    }
    public List<StoreDto> getAllStores(){
     return storeRepository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }
    public StoreDto getStoreById(Long id){
        return converter.convert(findStoreById(id));
    }
    private Store findStoreById(Long id){
        return storeRepository.findById(id).get();
    }
    public StoreDto createStore(CreateStoreRequest request){
    Store store=new Store(request.getName(),request.getAdress(),request.getEmail(),request.getPhone());
    return converter.convert(storeRepository.save(store));
    }
    public StoreDto updateStore(Long id, UpdateStoreRequest request){
    Store store = findStoreById(id);
    Store updatedStore= new Store(store.getId(),
            request.getName(),
            request.getAdress(),
            request.getEmail(),
            request.getPhone());
    return converter.convert(storeRepository.save(updatedStore));

    }
    public void deleteStore(Long id){
        storeRepository.deleteById(id);
    }

}
