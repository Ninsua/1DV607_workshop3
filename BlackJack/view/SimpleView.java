package BlackJack.view;

public class SimpleView implements IView {

    private int input;

    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }

        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }

    public void DisplayRules(int[] rules) {
        System.out.println("Rules");

        System.out.print("Wins on equal: ");
        if (rules[0] == 1)
            System.out.println("Dealer");
        else if (rules[0] == 2)
            System.out.println("Player");

        System.out.print("Hit strategy: ");
        if (rules[1] == 1)
            System.out.println("Standard");
        else if (rules[1] == 2)
            System.out.println("Soft 17");

        System.out.print("Dealing: ");
        if (rules[2] == 1)
            System.out.println("American");
        else if (rules[2] == 2)
            System.out.println("International");

        System.out.println();
    }

    private int GetInput() {
        try {
            int c = System.in.read();
            while (c == '\r' || c == '\n') {
                c = System.in.read();
            }
            return c;
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
    }

    public void collectSystemEvents() {
        input = GetInput();
    }

    public boolean newGameEvent() {
        return input == 'p';
    }

    public boolean hitEvent() {
        return input == 'h';
    }

    public boolean standEvent() {
        return input == 's';
    }

    public boolean quitEvent() {
        return input == 'q';
    }

    public void DisplayCard(BlackJack.model.Card a_card) {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        System.out.println(a_name + " Has: ");
        for (BlackJack.model.Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner) {
            System.out.println("Dealer Won!");
        } else {
            System.out.println("You Won!");
        }

    }

}
