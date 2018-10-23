package BlackJack.model.rules;
import BlackJack.model.rules.Win.*;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  
  public IWinStrategy getWinRule() {
	    return new EqualPlayerWins();
	  }
}