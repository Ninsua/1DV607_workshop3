package BlackJack.model.rules;

import BlackJack.model.rules.Win.*;

public interface IRulesFactory {
    public IHitStrategy getHitRule();
    public INewGameStrategy getNewGameRule();
    public IWinStrategy getWinRule();
}