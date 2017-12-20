package com.seavus.twitter;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seavus.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tweet {

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    @JsonManagedReference
    private User user;

    private String content;

    private int numberOfCharacters;

    public Tweet() {
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void addUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.numberOfCharacters = content.length();
    }

    public int getNumberOfCharacters() {
        return numberOfCharacters;
    }

    @Override
    public String toString() {
        return content;
    }
}
