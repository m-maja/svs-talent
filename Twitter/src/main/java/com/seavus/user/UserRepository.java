package com.seavus.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findById(Long id);

    User findByUsername(String username);
}
