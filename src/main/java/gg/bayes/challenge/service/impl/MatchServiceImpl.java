package gg.bayes.challenge.service.impl;

import gg.bayes.challenge.models.BuyEvent;

import gg.bayes.challenge.repositories.BuyEventRepository;
import gg.bayes.challenge.repositories.HitEventRepository;
import gg.bayes.challenge.repositories.KillEventRepository;
import gg.bayes.challenge.repositories.MatchRepository;
import gg.bayes.challenge.repositories.SpellEventRepository;

import gg.bayes.challenge.service.EventParser;
import gg.bayes.challenge.service.MatchService;

import java.util.Arrays;

import java.util.List;

import java.util.Random;


import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    MatchRepository matchRepository;
    BuyEventRepository buyEventRepository;
    HitEventRepository hitEventRepository;
    SpellEventRepository spellEventRepository;
    KillEventRepository killEventRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository, BuyEventRepository buyEventRepository,
            HitEventRepository hitEventRepository, SpellEventRepository spellEventRepository,
            KillEventRepository killEventRepository) {
        this.matchRepository = matchRepository;
        this.buyEventRepository = buyEventRepository;
        this.hitEventRepository = hitEventRepository;
        this.spellEventRepository = spellEventRepository;
        this.killEventRepository = killEventRepository;
    }

    @Override
    public Long ingestMatch(String payload) {
        Long matchId = new Random().nextLong();
        payload.lines().forEach(dataLine -> {
            Arrays.stream(EventParser.values()).map(parser -> parser.parse(matchId, dataLine)).filter(f -> f != null)
                    .findFirst().ifPresent(e -> matchRepository.save(e));
        });
        System.out.println("MatchId " + matchId);
        return matchId;
    }

    @Override
    public List<BuyEvent> getAllHeroItems(Long matchId, String hero) {
        return buyEventRepository.findAllHeroItems(matchId, hero);
    }

    @Override
    public List<Tuple> getAllHeroKills(Long matchId) {

        return killEventRepository.findAllHeroKills(matchId);
    }

    @Override
    public List<Tuple> getAllHeroHits(Long matchId, String hero){
        return hitEventRepository.findAlltHeroHits(matchId, hero);
    }

    @Override
    public List<Tuple> getAllHeroSpellCast(Long matchId, String hero){
        return spellEventRepository.findAlltHeroSpellsCasts(matchId, hero);
    }
}
