package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;
import BlackJack.model.rules.*;

public class Program {

  public static void main(String[] a_args) {

    Game g = new Game(new RulesStandard()); // RulesStandard, RulesCrazy and RulesGoofy available
    IView v = new SimpleView(); // new SwedishView();
    PlayGame ctrl = new PlayGame(g, v);

    while (ctrl.Play())
      ;
  }
}