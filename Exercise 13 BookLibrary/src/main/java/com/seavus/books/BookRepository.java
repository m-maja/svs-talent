package com.seavus.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends JpaRepository <Book, Long> {

    Book findByTitle(String title);
}
