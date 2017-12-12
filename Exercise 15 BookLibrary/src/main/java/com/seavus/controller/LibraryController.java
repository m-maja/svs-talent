package com.seavus.controller;

import com.seavus.books.Book;
import com.seavus.books.BookRepository;
import com.seavus.members.Member;
import com.seavus.members.MemberRepository;
import com.seavus.readers.ConsoleReaderAdapter;
import com.seavus.readers.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class LibraryController {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private Reader consoleReaderAdapter;

    @Autowired
    public LibraryController(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        consoleReaderAdapter = new ConsoleReaderAdapter();
    }

    public void startApplication() {
        int action;
        do{
            System.out.println("= Enter your action: = \n" +
                                "1-Add new book   \n" +
                                "2-List all books  \n" +
                                "3-Lend book to user  \n" +
                                "4-Add new member   \n" +
                                "5-List all members   \n" +
                                "0-Exit application");

            action = consoleReaderAdapter.readAction();

            switch (action){
                case 1:
                    try {
                        bookRepository.save(
                                consoleReaderAdapter.readBook()
                        );
                    } catch (Exception ex){
                        System.out.println("The title of the book MUST be UNIQUE!");
                    }
                    break;
                case 2:
                    listAllBooks();
                    break;
                case 3:
                    lendBook();
                    break;
                case 4:
                    memberRepository.save(
                            consoleReaderAdapter.readMember()
                    );
                    break;
                case 5:
                    listAllMembers();
                    break;
                case 0: break;
                default:
                    System.out.println("Your action was not recognized!");
            }
        } while (action != 0);

    }

    private void lendBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("= Which book do you want to lend? =");
        String bookTitle = scanner.nextLine();
        Book book = bookRepository.findByTitle(bookTitle);
        if (book == null){
            System.out.println("The book doesn't exist in the library!");
            return;
        }
        System.out.println("= Enter the name of the user =");
        String memberName = scanner.nextLine();
        Member member;
        try {
             member = memberRepository.findByName(memberName);
        } catch (Exception ex){
            System.out.println("There are more than one member with the same name!");
            return;
        }
        if (member == null){
            System.out.println("The library doesn't have member with that name!");
            return;
        }
        book.addMember(member);
        bookRepository.save(book);
    }

    private void listAllBooks() {
        List<Book> books = bookRepository.findAll();
        System.out.println("===== Listing all books ======");
        for (Book book: books) {
            System.out.println(book.toString());
        }
        System.out.println("===== END =====");
    }
    private void listAllMembers() {
        List<Member> members = memberRepository.findAll();
        System.out.println("===== Listing all members ======");
        for (Member member: members) {
            System.out.println(member.toString());
        }
        System.out.println("===== END =====");
    }
}
