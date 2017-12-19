package com.seavus.twitter;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    private TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/{id}")
    public Tweet getTweetById(@PathVariable Long id){
        return tweetService.getTweetById(id);
    }

    @PostMapping
    public void saveTweet(@RequestBody Tweet tweet){
        if (tweet == null)
            tweet = new Tweet();
        tweetService.saveTweet(tweet);
    }

    @GetMapping
    public List<Tweet> getAll() {
        return tweetService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteTweet(@PathVariable Long id){
        tweetService.deleteTweet(id);
    }
}
