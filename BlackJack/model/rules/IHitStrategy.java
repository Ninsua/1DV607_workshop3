package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy extends IRule {
    boolean DoHit(Player a_dealer);    
}