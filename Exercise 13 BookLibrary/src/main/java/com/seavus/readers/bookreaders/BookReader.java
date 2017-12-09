package com.seavus.readers.bookreaders;

import com.seavus.books.Book;

public interface BookReader {
    Book readBook();
    String readTitle();
    long readIsbn();
}
