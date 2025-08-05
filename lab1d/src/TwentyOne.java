



public class TwentyOne {

    static String[] cards = {"Ace Spades","2 Spades","3 Spades","4 Spades","5 Spades","6 Spades","7 Spades","8 Spades","9 Spades","10 Spades","Jack Spades","Queen Spades","King Spades","Ace Hearts","2 Hearts","3 Hearts","4 Hearts","5 Hearts","6 Hearts","7 Hearts","8 Hearts","9 Hearts","10 Hearts","Jack Hearts","Queen Hearts","King Hearts","Ace Clubs","2 Clubs","3 Clubs","4 Clubs","5 Clubs","6 Clubs","7 Clubs","8 Clubs","9 Clubs","10 Clubs","Jack Clubs","Queen Clubs","KingClubs","Ace Diamonds","2 Diamonds","3 Diamonds","4 Diamonds","5 Diamonds","6 Diamonds","7 Diamonds","8 Diamonds","9 Diamonds","10 Diamonds","Jack Diamonds","Queen Diamonds","King Diamonds"};

    public static void main(String[] args) {
        
        String[] myHand = new String[5];

        // get cards
        for(int i = 0; i < 5; i++){
            int selectedIndex = (int)(Math.random() * cards.length);

            myHand[i] = cards[selectedIndex];
        }
        



        System.out.print("The array: [ ");
        for(int i = 0; i< myHand.length; i++) {
        System.out.print(" " + myHand[i] + " ");
        }
        System.out.println("]");


        int sumOfCards = 0;

        for( String hand : myHand){
            String cardValue = hand.substring(0,hand.indexOf(" "));
            
            switch(cardValue){
                case "Ace", "King", "Queen", "Jack" -> sumOfCards += 10;
                default -> sumOfCards += Integer.parseInt(cardValue);
            }

        }

        System.out.println("Your hand is worth: " + sumOfCards);
    }


}
