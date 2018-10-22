package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.model.HandObserver;
import BlackJack.model.RuleVisitor;
import BlackJack.view.IView;

public class PlayGame implements HandObserver {

    private final int PAUSE_TIME = 1000;
    private Game a_game;
    private IView a_view;    
    private RuleVisitor a_visitor;

    public PlayGame(Game newGame, IView newView) {
        a_game = newGame;
        a_view = newView;
        a_visitor = newGame.getVisitor();
        
        a_game.addSubscriber(this);
        
        displayUI();
    }
    
    public boolean Play() {
        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }
        
        a_view.collectSystemEvents(); // listens to user input
        
        if (a_view.newGameEvent()) {
            a_game.NewGame();
        } else if (a_view.hitEvent()) {
            a_game.Hit();
        } else if (a_view.standEvent()) {
            a_game.Stand();
        }
        
        return !a_view.quitEvent();
    }
    
    public void handUpdate() {
        pause(PAUSE_TIME);
        displayUI();
    }
    
    private void displayUI() { // name change? ==========================================
        a_view.DisplayWelcomeMessage();
        a_view.DisplayRules(a_visitor.getRules());
        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
    }

    private void pause(final int TIME) {
        try {
            Thread.sleep(TIME);
        }
        catch(InterruptedException e) {
        }
    }
}