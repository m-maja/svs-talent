package com.seavus.twitter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TweetRepository extends JpaRepository<Tweet,Long>{

    Tweet findById(Long id);
}
