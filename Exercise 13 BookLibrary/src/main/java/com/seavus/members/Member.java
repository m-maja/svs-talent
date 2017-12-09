package com.seavus.members;

import com.seavus.books.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Member {

    @Id
    @GeneratedValue
    long id;
    private String name;

    @ManyToMany(mappedBy = "lendedByMembers", fetch = FetchType.EAGER)
    private Collection<Book> landedBooks;

    public Member() {
        landedBooks = new ArrayList<Book>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Book> getLandedBooks() {
        return landedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Member " + "id: ").append(id).append(", name: ").append(name);
        for (Book book :
                landedBooks) {
               stringBuilder.append("\t").append(book.toString());
        }
        return stringBuilder.toString();
    }

    public void setLandedBooks(Collection<Book> landedBooks) {
        this.landedBooks = landedBooks;
    }
}
