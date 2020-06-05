package com.epik.user_ev.persistence;

import com.epik.user_ev.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Set<User> findAllByEvId(Long evId);
}
