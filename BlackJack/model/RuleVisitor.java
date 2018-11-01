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

    // Wins on equal
    public void visit(EqualDealerWins eDealerWins) {
        equal = winsOnEqual.Dealer;
    }

    public void visit(EqualPlayerWins ePlayerWins) {
        equal = winsOnEqual.Player;
    }

    // Hit strategy
    public void visit(BasicHitStrategy bHitStrategy) {
        hit = hitStrategy.Basic;
    }

    public void visit(Soft17HitStrategy s17HitStrategy) {
        hit = hitStrategy.Soft17;
    }

    // New game deal
    public void visit(AmericanNewGameStrategy aNewGameStrategy) {
        newgame = newGameDeal.American;
    }

    public void visit(InternationalNewGameStrategy iNewGameStrategy) {
        newgame = newGameDeal.International;
    }

    // Return methods
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