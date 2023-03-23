package com.hc.udemy.repository;

import com.hc.udemy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByFirstName(String firstName);
}
