package gg.bayes.challenge.repositories;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gg.bayes.challenge.models.KillEvent;

@Repository
public interface KillEventRepository extends JpaRepository<KillEvent, Long> {
    @Query("SELECT m.hero, COUNT(k.id) FROM Match m LEFT JOIN KillEvent k ON k.id = m.id WHERE (m.matchId = :matchId) GROUP BY m.hero")
    List<Tuple> findAllHeroKills(Long matchId);
}
