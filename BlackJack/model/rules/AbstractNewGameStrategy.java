package BlackJack.model.rules;

import BlackJack.model.*;

abstract class AbstractNewGameStrategy {
    Card c;

    void dealToPlayer(Deck a_deck, Dealer a_dealer, Player a_player) {        
        c = a_deck.GetCard();
        c.Show(true);
        a_player.DealCard(c);
        a_dealer.notifySubscribers();
    }

    void dealToDealer(Deck a_deck, Dealer a_dealer, boolean showCard) {
        c = a_deck.GetCard();
        c.Show(showCard);
        a_dealer.DealCard(c);
        a_dealer.notifySubscribers();
    }
}