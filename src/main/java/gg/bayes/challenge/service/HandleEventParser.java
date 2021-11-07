package gg.bayes.challenge.service;


import java.util.regex.*;

import gg.bayes.challenge.models.Match;

public interface HandleEventParser {

    public Long genTimeStamp(String rawTime);
    
    Match generateEvent(Long matchId, Matcher matcher);


    
}
