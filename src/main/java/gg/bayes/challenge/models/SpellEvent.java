package gg.bayes.challenge.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpellEvent extends Match {

    @NotEmpty
    private String spell;
    @NotEmpty
    private String victim;
    @NotNull
    @Positive
    private Integer spellLevel;

    public SpellEvent(Long matchId, Long timestamp, String hero, String spell, String victim, Integer spellLevel) {
        super(matchId, timestamp, hero);
        this.spell = spell;
        this.victim = victim;
        this.spellLevel = spellLevel;
    }

}
