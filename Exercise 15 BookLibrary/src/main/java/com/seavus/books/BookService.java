package com.seavus.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public  BookService (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void createBook (Book book){
        bookRepository.save(book);
    }

    public Book getBook(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> findAll (){
       return bookRepository.findAll();
    }

}
