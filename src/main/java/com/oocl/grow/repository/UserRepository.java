package com.oocl.grow.repository;

import com.oocl.grow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
    User findByUserId(int userid);
}
