package BlackJack.model.rules;

import BlackJack.model.rules.Win.EqualDealerWins;
import BlackJack.model.rules.Win.IWinStrategy;

class RulesGoofy implements IRulesFactory {
    @Override
    public IHitStrategy getHitRule() {
        return new BasicHitStrategy();
    }

    @Override
    public INewGameStrategy getNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    @Override
    public IWinStrategy getWinRule() {
		return new EqualDealerWins();
	}
}