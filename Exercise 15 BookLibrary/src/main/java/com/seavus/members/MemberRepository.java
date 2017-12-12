package com.seavus.members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findById (Long id);
    Member findByName (String name);
    List<Member> findAll();
}
