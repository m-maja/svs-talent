package com.seavus.controller;

import com.seavus.readers.ConsoleTweetReaderAdapter;
import com.seavus.twitter.Tweet;
import com.seavus.twitter.TweetRepository;
import com.seavus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {
    private ConsoleTweetReaderAdapter consoleTweetReaderAdapter;
    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    @Autowired
    public MainController(TweetRepository tweetRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.consoleTweetReaderAdapter = new ConsoleTweetReaderAdapter();
        this.tweetRepository = tweetRepository;
    }

    public void startApplication (){
        int action = 1;

        do {
            System.out.println("= Enter your action: = \n" +
                    "1-Add new tweet   \n" +
                    "2-List all tweets  \n" +
                    "3-Add new user \n" +
                    "0-Exit application");
            action = consoleTweetReaderAdapter.readAction();

            switch (action){
                case 1:
                    Tweet tweet = consoleTweetReaderAdapter.readTweet();
                    tweet.addUser(userRepository.findById((long) 1));
                    tweetRepository.save(tweet);
                    break;
                case 2:
                    System.out.println(tweetRepository.findAll().toString());
                    break;
                case 3:
                    userRepository.save(
                            consoleTweetReaderAdapter.readUser()
                    );

            }
        } while (action != 0);
    }
}
