package gg.bayes.challenge.repositories;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gg.bayes.challenge.models.SpellEvent;

@Repository
public interface SpellEventRepository extends JpaRepository<SpellEvent, Long> {

    @Query("SELECT s.spell, COUNT(s.id) FROM SpellEvent s WHERE (s.matchId = :matchId) AND (s.hero = :hero) GROUP BY s.spell")
    List<Tuple> findAlltHeroSpellsCasts(Long matchId, String hero);
}
