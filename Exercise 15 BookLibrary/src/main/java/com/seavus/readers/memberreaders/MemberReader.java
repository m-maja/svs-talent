package com.seavus.readers.memberreaders;

import com.seavus.members.Member;

public interface MemberReader {
    String readName();
    Member readMember();
}
