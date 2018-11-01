package BlackJack.model.rules.Win;

import BlackJack.model.Player;
import BlackJack.model.RuleVisitor;
import BlackJack.model.Dealer;

public class EqualDealerWins implements IWinStrategy {
	
	//A smaller piece of the algorithm could be implemented here.
	//Currently _some_ code duplication but this allows for more flexible win algorithms
	public boolean dealerWins(Player aPlayer, Dealer aDealer, int maxScore) {
	    if (aPlayer.CalcScore() > maxScore) {
	        return true;
	      } else if (aDealer.CalcScore() > maxScore) {
	        return false;
	      }
	      return aDealer.CalcScore() >= aPlayer.CalcScore();
	}

	public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}
