package BlackJack.model.rules;

import BlackJack.model.rules.Win.*;

public class RulesStandard implements IRulesFactory {
  public IHitStrategy getHitRule() {
    return new BasicHitStrategy();
  }

  public INewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  public IWinStrategy getWinRule() {
    return new EqualPlayerWins();
  }
}