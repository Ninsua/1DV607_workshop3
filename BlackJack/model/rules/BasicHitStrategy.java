package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.model.RuleVisitor;

public class BasicHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
      return a_dealer.CalcScore() < g_hitLimit;  
    }

    public void accept(RuleVisitor visitor) {
      visitor.visit(this);
    }
}