package gg.bayes.challenge.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class KillEvent extends Match {

    @NotEmpty
    private String kill;

    

    public KillEvent(Long matchId, Long timestamp, String hero, String kill) {
        super(matchId, timestamp, hero);
        this.kill = kill;
    }

}
