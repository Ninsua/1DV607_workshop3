package BlackJack.view;

public class SwedishView implements IView 
    {
	
	private int input;
	
        public void DisplayWelcomeMessage()
        {         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};

            System.out.println("Hej Black Jack Världen");
            System.out.println("----------------------");
            System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
        }

        public void DisplayRules(int[] rules) {
            System.out.println("Regler");
    
            System.out.print("Vinner vid lika: ");
            if (rules[0] == 1)
                System.out.println("Croupiern");
            else if (rules[0] == 2)
                System.out.println("Spelaren");
    
            System.out.print("Nytt kort: ");
            if (rules[1] == 1)
                System.out.println("Standard");
            else if (rules[1] == 2)
                System.out.println("Soft 17");
    
            System.out.print("Speltyp: ");
            if (rules[2] == 1)
                System.out.println("Amerikansk");
            else if (rules[2] == 2)
                System.out.println("Internationell");
    
            System.out.println();
        }

        private int GetInput()
        {
          try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
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
        
        public void DisplayCard(BlackJack.model.Card a_card)
        {
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String values[] =  
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
        }
    }
