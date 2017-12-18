package com.seavus.user;

import com.seavus.twitter.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/tweets")
    public List<Tweet> getTweetsOfUserWithId(@PathVariable Long id){
        return userService.getTweetsOfUserWithId(id);
    }

    @PutMapping("/{id}/follows/{id2}")
    public void followUser(@PathVariable Long id, @PathVariable Long id2){
        userService.followUser(id, id2);
    }

    @PutMapping("/{id}/unfollow/{id2}")
    public void unfollowUser(@PathVariable Long id, @PathVariable Long id2){
        userService.unfollowUser(id, id2);
    }
}
