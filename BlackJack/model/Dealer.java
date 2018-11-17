package BlackJack.model;

import java.util.ArrayList;

import BlackJack.model.rules.*;

import BlackJack.model.rules.Win.IWinStrategy;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;	
  private IWinStrategy m_winRule;
  private ArrayList<HandObserver> subscribers;
  private RuleVisitor visitor = new RuleVisitor();

  public Dealer(IRulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.getNewGameRule();
    m_hitRule = a_rulesFactory.getHitRule();
    m_winRule = a_rulesFactory.getWinRule();	//Creates win algorithm

    // Ruleset accepts rule visitor
    m_newGameRule.accept(visitor);
    m_hitRule.accept(visitor);
    m_winRule.accept(visitor);
    
    subscribers = new ArrayList<>();
  }
  
  void addSubscriber(HandObserver newSubscriber) {
    subscribers.add(newSubscriber);
  }

  public void notifySubscribers() {
    for(HandObserver subscriber : subscribers) {
      subscriber.handUpdate();
    }
  }
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      
      return  m_newGameRule.NewGame(m_deck, this, a_player);
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      giveCard(a_player, true);
      
      return true;
    }
    return false;
  }
  
  public boolean Stand(Player a_player) {
	  if (m_deck != null) {
		  ShowHand();
      
      notifySubscribers();
		  
		  while(m_hitRule.DoHit(this)) {
       giveCard(this, true);
		  }
	  }
	  
	  return true;
  }

  public boolean IsDealerWinner(Player a_player) {
	  return m_winRule.dealerWins(a_player, this, g_maxScore);	//Strategy for win algorithm
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }

  public void giveCard(Player player, boolean showCard) {
    Card c = m_deck.GetCard();
    c.Show(showCard);
    player.DealCard(c);
    notifySubscribers();
  }
  
  public RuleVisitor getVisitor() {
    return visitor;
  }
  
}