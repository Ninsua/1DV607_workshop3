package BlackJack.model.rules;

import BlackJack.model.rules.Win.EqualPlayerWins;
import BlackJack.model.rules.Win.IWinStrategy;

class RulesCrazy implements IRulesFactory {
    @Override
    public IHitStrategy getHitRule() {
        return new BasicHitStrategy(); //TODO kom på någon ny hit strategy och implementera
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