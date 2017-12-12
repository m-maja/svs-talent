package com.seavus;

import com.seavus.controller.LibraryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookApplication {
    public static void main (String[]args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(BookApplication.class, args);

        applicationContext.getBean(LibraryController.class).startApplication();
        applicationContext.close();
    }
}
