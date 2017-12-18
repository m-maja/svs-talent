package com.seavus.user;

import com.seavus.twitter.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
