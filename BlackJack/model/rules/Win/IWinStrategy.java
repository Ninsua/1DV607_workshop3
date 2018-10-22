package BlackJack.model.rules.Win;

import BlackJack.model.Player;
import BlackJack.model.RuleVisitor;
import BlackJack.model.Dealer;

public interface IWinStrategy {
	public boolean dealerWins(Player aPlayer, Dealer aDealer, int maxScore);
	void accept(RuleVisitor visitor);
}
