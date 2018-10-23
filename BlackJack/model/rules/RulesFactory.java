package BlackJack.model.rules;
import BlackJack.model.rules.Win.*;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new Soft17HitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new InternationalNewGameStrategy();
  }
  
  public IWinStrategy getWinRule() {
	    return new EqualPlayerWins();
	  }
}