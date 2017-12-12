package com.seavus.readers.bookreaders;

import com.seavus.books.Book;

import java.util.Scanner;

public class ConsoleBookReader implements BookReader {
    private Scanner scanner;

    public ConsoleBookReader() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Book readBook() {
        scanner = new Scanner(System.in);
        Book book = new Book();
        book.setTitle(this.readTitle());
        book.setIsbn(this.readIsbn());
        return book;
    }

    @Override
    public String readTitle() {
        System.out.println("=== Enter book's title: ");
        return scanner.nextLine();
    }

    @Override
    public long readIsbn() {
        System.out.println("=== Enter book's isbn: ");
        Long isbn = null;
        do{
            try {
                isbn = scanner.nextLong();
            } catch (RuntimeException ex){
                System.out.println("The isbn must be of type long! Please enter again!");
            }
        } while (isbn == null);

        return isbn;
    }
}
