package com.project.Book_api.Service;

import com.project.Book_api.Entity.Book;
import com.project.Book_api.Respo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo){
        this.repo=repo;
    }

    public List<Book> getAll(){
        return repo.findAll();
    }

    public Book getById(Long Id){
        return repo.findById(Id)
                .orElseThrow(()-> new RuntimeException("Book not found with id "+Id));
    }

    public Book create(Book request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPages(request.getPages());
        book.setPrice(request.getPrice());
        return repo.save(book);
    }

    public Book update(Long id, Book request) {
        Book existing = getById(id);
        existing.setTitle(request.getTitle());
        existing.setAuthor(request.getAuthor());
        existing.setPages(request.getPages());
        existing.setPrice(request.getPrice());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
