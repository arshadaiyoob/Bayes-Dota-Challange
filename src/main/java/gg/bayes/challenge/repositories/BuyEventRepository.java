package gg.bayes.challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gg.bayes.challenge.models.BuyEvent;

@Repository
public interface BuyEventRepository extends JpaRepository<BuyEvent, Long> {
    @Query("SELECT b FROM BuyEvent b WHERE (b.matchId = :matchId) and (b.hero = :hero)")
List<BuyEvent> findAllHeroItems(Long matchId, String hero);
}
