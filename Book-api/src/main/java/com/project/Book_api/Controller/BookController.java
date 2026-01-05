package com.project.Book_api.Controller;
import com.project.Book_api.Entity.Book;
import com.project.Book_api.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book request) {
        Book created = service.create(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @Valid @RequestBody Book request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}