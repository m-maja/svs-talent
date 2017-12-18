package com.seavus.twitter;

import java.util.ArrayList;
import java.util.List;

public class TweetHolder {
    List<Tweet> tweets;

    public TweetHolder() {
        tweets = new ArrayList<Tweet>();
    }

    public void addTweet (Tweet tweet){
        tweets.add(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Tweet tweet : tweets) {
            stringBuilder.append(tweet.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
