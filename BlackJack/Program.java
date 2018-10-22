package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;
import BlackJack.model.rules.*;

public class Program {

  public static void main(String[] a_args) {

    Game g = new Game(new RulesCrazy()); // RulesStandard, RulesCrazy and RulesGoofy available
    //IView v = new SimpleView(); // new SwedishView();
    IView v = new SwedishView();
    PlayGame ctrl = new PlayGame(g, v);

    while (ctrl.Play())
      ;
  }
}