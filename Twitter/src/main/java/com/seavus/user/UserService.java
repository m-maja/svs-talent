package com.seavus.user;

import com.seavus.twitter.Tweet;
import com.seavus.twitter.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    @Autowired
    public UserService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public List<Tweet> getTweetsOfUserWithId(Long id) {
        User user = getUserById(id);
        return user.getTweets();
    }

    public void followUser(Long id, Long id2) {
        User user = getUserById(id);
        User follow = getUserById(id2);
        user.followUser(follow);
        userRepository.save(user);
    }

    public void unfollowUser(Long id, Long id2) {
        User user = getUserById(id);
        User unfollow = getUserById(id2);
        user.unfollowUser(unfollow);
    }

    public User getUserByUsername(String username) {
        return  userRepository.findByUsername(username);
    }

    public void addTweetToUserWithId(long id, Tweet tweet) {
        User user = getUserById(id);
        tweet.addUser(user);
        tweetRepository.save(tweet);
    }
}
