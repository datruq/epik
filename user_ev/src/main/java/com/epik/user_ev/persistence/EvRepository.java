package com.epik.user_ev.persistence;

import com.epik.user_ev.domain.Ev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvRepository extends JpaRepository<Ev, Long> {

    @Query("SELECT uev FROM User u JOIN u.ev uev WHERE u.email=:email")
    public Optional<Ev> findByUserEmail(@Param("email") String email);
}
