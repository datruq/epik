package com.epik.user_ev.persistence;

import com.epik.user_ev.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public User findByEmail(String email);
}