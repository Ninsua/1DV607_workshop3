package BlackJack.model.rules;

import BlackJack.model.rules.Win.EqualPlayerWins;
import BlackJack.model.rules.Win.IWinStrategy;

public class RulesCrazy implements IRulesFactory {
    @Override
    public IHitStrategy getHitRule() {
        return new Soft17HitStrategy(); 
    }

    @Override
    public INewGameStrategy getNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    @Override
    public IWinStrategy getWinRule() {
		return new EqualPlayerWins();
	}
}