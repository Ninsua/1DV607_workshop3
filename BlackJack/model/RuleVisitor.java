package BlackJack.model;

import BlackJack.model.rules.*;
import BlackJack.model.rules.Win.*;

public class RuleVisitor {
    public enum winsOnEqual { Player, Dealer }
    public enum hitStrategy { Basic, Soft17 }
    public enum newGameDeal { International, American } 
    private winsOnEqual equal;
    private hitStrategy hit;
    private newGameDeal newgame;        
     

    /* Win conditions
    ** 1 = Dealer wins on equal
    ** 2 = Player wins on equal */
    public void visit(EqualDealerWins eDealerWins) {
        equal = winsOnEqual.Dealer;
    }

    public void visit(EqualPlayerWins ePlayerWins) {
        equal = winsOnEqual.Player;
    }

    /* Hit strategies
    ** 1 = Basic hit strategy
    ** 2 = Soft 17 hit strategy */
    public void visit(BasicHitStrategy bHitStrategy) {
        hit = hitStrategy.Basic;
    }

    public void visit(Soft17HitStrategy s17HitStrategy) {
        hit = hitStrategy.Soft17;
    }

    /* New game strategies
    ** 1 = American new game strategy
    ** 2 = International new game strategy */
    public void visit(AmericanNewGameStrategy aNewGameStrategy) {
        newgame = newGameDeal.American;
    }

    public void visit(InternationalNewGameStrategy iNewGameStrategy) {
        newgame = newGameDeal.International;
    }

    public RuleVisitor getRules() {
        return this;
    }

    public winsOnEqual getWinsOnEqual() {
        return equal;
    }

    public hitStrategy getHitStrategy() {
        return hit;
    }

    public newGameDeal getNewGameDeal() {
        return newgame;
    }
}