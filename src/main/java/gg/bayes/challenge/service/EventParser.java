package gg.bayes.challenge.service;

import java.time.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gg.bayes.challenge.models.BuyEvent;
import gg.bayes.challenge.models.HitEvent;
import gg.bayes.challenge.models.KillEvent;
import gg.bayes.challenge.models.SpellEvent;

import gg.bayes.challenge.models.Match;

public enum EventParser implements HandleEventParser {

    SPELL("^\\[(.*)\\] npc_dota_hero_(.*) casts ability (.*) \\(lvl (\\d+)\\) on (.*)$") {

        @Override
        public SpellEvent generateEvent(Long matchId, Matcher matcher) {
            String victim;
            if (matcher.group(5).startsWith("npc_dota_hero_")) {
                victim = matcher.group(5).substring(14);
            } else if (matcher.group(5).startsWith("npc_dota_")) {
                victim = matcher.group(5).substring(9);
            } else {
                victim = matcher.group(5);
            }
            // System.out.println(matchId + " " + SPELL.genTimeStamp(matcher.group(1)) + " "
            // + matcher.group(2) + " "
            // + matcher.group(3) + " " + victim + " " +
            // Integer.parseInt(matcher.group(4)));
            return new SpellEvent(matchId, SPELL.genTimeStamp(matcher.group(1)), matcher.group(2), matcher.group(3),
                    victim, Integer.parseInt(matcher.group(4)));
        }

    },

    KILL("^\\[(.*)\\] npc_dota_hero_(.*) is killed by npc_dota_hero_(.*)") {
        @Override
        public KillEvent generateEvent(Long matchId, Matcher matcher) {
            return new KillEvent(matchId, KILL.genTimeStamp(matcher.group(1)), matcher.group(3), matcher.group(2));
        }
    },

    HIT("^\\[(.*)\\] npc_dota_hero_(.*) hits npc_dota_hero_(.*) with (.*) for (\\d+) damage.*$") {
        @Override
        public HitEvent generateEvent(Long matchId, Matcher matcher) {
            return new HitEvent(matchId, HIT.genTimeStamp(matcher.group(1)), matcher.group(2),
                    Integer.parseInt(matcher.group(5)), matcher.group(4), matcher.group(3));

        }
    },

    BUY("^\\[(.*)\\] npc_dota_hero_(.*) buys item item_(.*)$") {
        @Override
        public BuyEvent generateEvent(Long matchId, Matcher matcher) {
            return new BuyEvent(matchId, BUY.genTimeStamp(matcher.group(1)), matcher.group(2), matcher.group(3));
        }
    };

    @Override
    public Long genTimeStamp(String rawTime) {
        return Duration.between(LocalTime.MIDNIGHT, LocalTime.parse(rawTime)).toMillis();
    }

    public final Pattern pattern;

    EventParser(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Match parse(Long matchId, String data) {
        Matcher match = pattern.matcher(data);
        return match.matches() ? generateEvent(matchId, match) : null;

    }
}
