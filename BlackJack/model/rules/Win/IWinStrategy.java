package BlackJack.model.rules.Win;

import BlackJack.model.Player;

import BlackJack.model.rules.IRule;
import BlackJack.model.Dealer;

public interface IWinStrategy extends IRule {
	public boolean dealerWins(Player aPlayer, Dealer aDealer, int maxScore);	
}
