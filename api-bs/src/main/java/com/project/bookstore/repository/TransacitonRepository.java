package com.project.bookstore.repository;

import com.project.bookstore.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacitonRepository extends JpaRepository<Transaction,Long> {
}
