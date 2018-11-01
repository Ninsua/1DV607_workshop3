package BlackJack.view;

import BlackJack.model.RuleVisitor.*;

public interface IView
{
  void DisplayWelcomeMessage();
  void DisplayRules(winsOnEqual equal, hitStrategy strategy, newGameDeal deal);
  void collectSystemEvents();
  boolean newGameEvent();
  boolean hitEvent();
  boolean standEvent();
  boolean quitEvent();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
}