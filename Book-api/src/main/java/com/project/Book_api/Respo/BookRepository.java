package com.project.Book_api.Respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Book_api.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
