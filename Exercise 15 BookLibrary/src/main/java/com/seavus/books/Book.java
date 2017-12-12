package com.seavus.books;

import com.seavus.members.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Book {

    @Id @GeneratedValue long id;
    private long isbn;
    @Column(unique = true) private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Member> lendedByMembers;

    public Book() {
        lendedByMembers = new ArrayList<Member>();
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void addMember (Member member){
        lendedByMembers.add(member);
    }

    public long getId() {
        return id;
    }

    public Collection<Member> getLendedByMembers() {
        return lendedByMembers;
    }

    public void setLendedByMembers(Collection<Member> lendedByMembers) {
        this.lendedByMembers = lendedByMembers;
    }

    @Override
    public String toString() {
        return String.format("--Book title=%s, id=%d, isbn=%d ",title, id, isbn);
    }
}
