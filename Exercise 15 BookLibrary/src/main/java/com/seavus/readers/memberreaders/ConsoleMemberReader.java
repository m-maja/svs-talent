package com.seavus.readers.memberreaders;

import com.seavus.members.Member;

import java.util.Scanner;

public class ConsoleMemberReader implements MemberReader {
    private Scanner scanner;

    public ConsoleMemberReader() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readName() {
        return scanner.nextLine();
    }

    @Override
    public Member readMember() {
        Member member = new Member();
        String name = readName();
        member.setName(name);
        return member;
    }
}
