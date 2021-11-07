package gg.bayes.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gg.bayes.challenge.models.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

}
