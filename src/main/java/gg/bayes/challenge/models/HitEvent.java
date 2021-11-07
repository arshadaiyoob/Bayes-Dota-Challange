package gg.bayes.challenge.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class HitEvent extends Match {

    @NotNull
    @Positive
    public Integer damage;
    @NotEmpty
    public String weapon;
    @NotEmpty
    public String victim;

   

    public HitEvent(Long matchId, Long timestamp, String hero, Integer damage, String weapon, String victim) {
        super(matchId, timestamp, hero);
        this.damage = damage;
        this.weapon = weapon;
        this.victim = victim;
    }
}
