package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.RuleVisitor;

public class InternationalNewGameStrategy extends AbstractNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    dealToPlayer(a_deck, a_dealer, a_player);
    dealToDealer(a_deck, a_dealer);
    dealToPlayer(a_deck, a_dealer, a_player);
    
    return true;
  }

  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}