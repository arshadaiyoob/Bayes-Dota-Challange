package gg.bayes.challenge.repositories;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gg.bayes.challenge.models.HitEvent;

@Repository
public interface HitEventRepository extends JpaRepository<HitEvent, Long> {

    @Query("SELECT h.victim, COUNT(h.id), SUM(h.damage) FROM HitEvent h WHERE (h.matchId = :matchId) AND (h.hero = :hero) GROUP BY h.victim")
    List<Tuple> findAlltHeroHits(Long matchId, String hero);

}
