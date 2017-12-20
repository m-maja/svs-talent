package com.seavus.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seavus.twitter.Tweet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id @GeneratedValue
    private long id;

    @Column(unique = true)
    private String username;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Tweet> tweets;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    private List<User> followingUsers;

    @ManyToMany(mappedBy = "followingUsers",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<User> followers;

    public User() {
        username = "Anonymous";
        followingUsers = new ArrayList<User>();
        followers = new ArrayList<User>();
    }

    public User(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public void addNewTweet(Tweet tweet){
        tweets.add(tweet);
    }

    public void addFollower (User follower){
        followers.add(follower);
    }

    public void followUser (User following){
        followingUsers.add(following);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean unfollowUser(User unfollow) {
        return followingUsers.remove(unfollow);
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowingUsers() {
        return followingUsers;
    }
}
