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
public class BuyEvent extends Match {
    @NotEmpty
    private String item;

    
    public BuyEvent(Long matchId, Long timestamp, String hero, String item) {
        super(matchId, timestamp, hero);
        this.item = item;

    }

}