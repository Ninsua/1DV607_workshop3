package BlackJack.model;

import java.util.ArrayList;
import java.util.Arrays;

import BlackJack.model.rules.*;
import BlackJack.model.rules.Win.*;

public class RuleVisitor {
    int[] rules = new int[3];

    /* Win conditions
    ** 1 = Dealer wins on equal
    ** 2 = Player wins on equal */
    public void visit(EqualDealerWins eDealerWins) {
        rules[0] = 1;
    }

    public void visit(EqualPlayerWins ePlayerWins) {
        rules[0] = 2;
    }

    /* Hit strategies
    ** 1 = Basic hit strategy
    ** 2 = Soft 17 hit strategy */
    public void visit(BasicHitStrategy bHitStrategy) {
        rules[1] = 1;
    }

    public void visit(Soft17HitStrategy s17HitStrategy) {
        rules[1] = 2;
    }

    /* New game strategies
    ** 1 = American new game strategy
    ** 2 = International new game strategy */
    public void visit(AmericanNewGameStrategy aNewGameStrategy) {
        rules[2] = 1;
    }

    public void visit(InternationalNewGameStrategy iNewGameStrategy) {
        rules[2] = 2;
    }

    public int[] getRules() {
        return Arrays.copyOf(rules, rules.length);
    }
}