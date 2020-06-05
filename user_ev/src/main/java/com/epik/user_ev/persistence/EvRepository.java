package com.epik.user_ev.persistence;

import com.epik.user_ev.domains.Ev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EvRepository extends JpaRepository<Ev, Long> {

    @Query("SELECT uev.model, COUNT(uev) FROM User u JOIN u.ev uev WHERE u.ev.id=uev.id GROUP BY uev.model ORDER BY uev.model")
    public Object[] getMostPopularModel();

}
