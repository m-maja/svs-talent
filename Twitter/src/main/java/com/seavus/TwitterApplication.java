package com.seavus;

import com.seavus.controller.ConsoleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TwitterApplication {

    public static void main(String[]args){
        ConfigurableApplicationContext context =
                SpringApplication.run(TwitterApplication.class, args);

        context.getBean(ConsoleController.class).startApplication();
        context.close();
    }
}
