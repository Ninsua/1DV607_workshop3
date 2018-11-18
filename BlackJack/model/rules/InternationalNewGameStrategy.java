package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.RuleVisitor;

public class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    a_dealer.dealCard(a_player, true);
    a_dealer.dealCard(a_dealer, true);
    a_dealer.dealCard(a_player, true);
   
    return true;
  }

  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}