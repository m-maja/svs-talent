package com.seavus.readers;

import com.seavus.books.Book;
import com.seavus.members.Member;

public interface Reader {
    Book readBook ();
    int readAction ();
    Member readMember();
}
