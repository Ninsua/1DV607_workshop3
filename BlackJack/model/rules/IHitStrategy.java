package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.model.RuleVisitor;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
    void accept(RuleVisitor visitor);
}