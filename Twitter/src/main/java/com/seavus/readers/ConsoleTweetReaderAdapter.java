package com.seavus.readers;

import com.seavus.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.seavus.twitter.Tweet;

import java.util.Scanner;

@Component
public class ConsoleTweetReaderAdapter {

    @Autowired
    public ConsoleTweetReaderAdapter() {

    }

    /**
     * Reads actions from console
     * @return action or -1 if there is no correct action entered
     */
    public int readAction(){
        int action;
        Scanner scanner = new Scanner(System.in);
        try{
            action = scanner.nextInt();
            return action;
        } catch (Exception e){
            System.out.println("Your input can not be parsed, please try again!");
            return -1;
        }
    }

    public Tweet readTweet(){
        System.out.println("= Enter your content: =");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        Tweet tweet = new Tweet();
        tweet.setContent(content);
        return tweet;
    }

    public User readUser() {
        System.out.println("= Enter your name: =");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return new User(name);
    }
}
