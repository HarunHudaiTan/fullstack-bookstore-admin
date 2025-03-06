package com.project.bookstore.controller;

import com.project.bookstore.dto.StoreDto;
import com.project.bookstore.dto.request.CreateStoreRequest;
import com.project.bookstore.dto.request.UpdateStoreRequest;
import com.project.bookstore.model.Store;
import com.project.bookstore.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/store")
public class StoreController {
    private final StoreService storeService;
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @GetMapping
    public ResponseEntity <List<StoreDto>> findAll() {
        return ResponseEntity.ok(storeService.getAllStores());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }
    @PostMapping
    public ResponseEntity<StoreDto> save(@RequestBody CreateStoreRequest request) {
        return ResponseEntity.ok(storeService.createStore(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<StoreDto> update(@PathVariable("id") Long id ,@RequestBody UpdateStoreRequest request) {
        return ResponseEntity.ok(storeService.updateStore(id,request));
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}
