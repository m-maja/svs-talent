package com.seavus.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    private TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public void saveTweet(Tweet tweet){
        tweetRepository.save(tweet);
    }

    public Tweet getTweetById(Long id){
        return tweetRepository.findById(id);
    }

    public List<Tweet> getAll(){
        return tweetRepository.findAll();
    }

    public void deleteTweet(Long id){
        tweetRepository.delete(id);
    }
}
