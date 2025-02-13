package com.project.bookstore.service;

import com.project.bookstore.model.Publisher;
import com.project.bookstore.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    public Publisher updatePublisher(Long id, Publisher publisher) {
        Publisher existingPublisher = getPublisherById(id);
        Publisher updatedPublisher = new Publisher(
                existingPublisher.getId(),
                publisher.getName(),
                existingPublisher.getBooks()
        );
        return publisherRepository.save(updatedPublisher);
    }
}
