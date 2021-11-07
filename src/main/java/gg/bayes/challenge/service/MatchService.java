package gg.bayes.challenge.service;

import java.util.List;

import javax.persistence.Tuple;

import gg.bayes.challenge.models.BuyEvent;

public interface MatchService {
    
    Long ingestMatch(String payload);

    List<BuyEvent> getAllHeroItems(Long matchId, String hero);

    List<Tuple> getAllHeroKills(Long matchId);

    List<Tuple> getAllHeroHits(Long matchId, String hero);

    List<Tuple> getAllHeroSpellCast(Long matchId, String hero);
    // TODO add more methods as needed
}
