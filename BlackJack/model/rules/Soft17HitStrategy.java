package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

class Soft17HitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
    	int aces = 0;
    	int tens = 0;
    	int score =	a_dealer.CalcScore();
    	
    	//Count aces and tens
    	for (Card c : a_dealer.GetHand()) {
    		if (isAce(c)) {
    			aces++;
    		}
    		else if (isTen(c)) {
    			tens++;
    		}
    	}
    	
    	//Only hit if Ace is on hand, no tens. Ie a soft 17.
    	if (aces > 0 && tens == 0 && score == g_hitLimit) {
    		return true;
    	}

      return score < g_hitLimit; 
    }
    
    private boolean isAce(Card c) {
    	return c.GetValue() == Card.Value.Ace;
    }
    
    private boolean isTen(Card c) {
    	Card.Value value = c.GetValue();
    	
    	if (value == Card.Value.Ten)
    		return true;
    	else if (value == Card.Value.Knight)
    		return true;
    	else if (value == Card.Value.Queen)
    		return true;
    	else if (value == Card.Value.King)
    		return true;
 
    	return false;
    }
}