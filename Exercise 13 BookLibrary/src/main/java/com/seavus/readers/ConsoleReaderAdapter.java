package com.seavus.readers;

import com.seavus.books.Book;
import com.seavus.members.Member;
import com.seavus.readers.bookreaders.BookReader;
import com.seavus.readers.bookreaders.ConsoleBookReader;
import com.seavus.readers.commandreaders.CommandReader;
import com.seavus.readers.commandreaders.ConsoleCommandReader;
import com.seavus.readers.memberreaders.ConsoleMemberReader;
import com.seavus.readers.memberreaders.MemberReader;

public class ConsoleReaderAdapter implements Reader {
    private BookReader bookReader;
    private MemberReader memberReader;
    private CommandReader actionReader;

    public ConsoleReaderAdapter() {
        bookReader = new ConsoleBookReader();
        memberReader = new ConsoleMemberReader();
        actionReader = new ConsoleCommandReader();
    }

    @Override
    public Book readBook() {
        return bookReader.readBook();
    }

    @Override
    public int readAction() {
        int action;
        do {
            try{
                action = actionReader.readCommand();
            } catch (RuntimeException ex){
                action = -1;
                System.out.println(ex.getMessage() + " Please enter your command again! ");
            }
        } while (action == -1);
        return action;
    }

    @Override
    public Member readMember() {
        System.out.println("=== Enter member's name: ");
        return memberReader.readMember();
    }
}
