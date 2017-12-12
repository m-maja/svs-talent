package com.seavus.controller;

import com.seavus.books.BookRepository;
import com.seavus.members.MemberRepository;
import com.seavus.readers.ConsoleReaderAdapter;
import com.seavus.readers.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class LibraryRestController {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private Reader consoleReaderAdapter;

    @Autowired
    public LibraryRestController(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        consoleReaderAdapter = new ConsoleReaderAdapter();
    }


}
