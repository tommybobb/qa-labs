
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



public class TwentyOneAdvanced {

    static String[] cards = {"Ace Spades","2 Spades","3 Spades","4 Spades","5 Spades","6 Spades","7 Spades","8 Spades","9 Spades","10 Spades","Jack Spades","Queen Spades","King Spades","Ace Hearts","2 Hearts","3 Hearts","4 Hearts","5 Hearts","6 Hearts","7 Hearts","8 Hearts","9 Hearts","10 Hearts","Jack Hearts","Queen Hearts","King Hearts","Ace Clubs","2 Clubs","3 Clubs","4 Clubs","5 Clubs","6 Clubs","7 Clubs","8 Clubs","9 Clubs","10 Clubs","Jack Clubs","Queen Clubs","KingClubs","Ace Diamonds","2 Diamonds","3 Diamonds","4 Diamonds","5 Diamonds","6 Diamonds","7 Diamonds","8 Diamonds","9 Diamonds","10 Diamonds","Jack Diamonds","Queen Diamonds","King Diamonds"};

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String[] myHand = new String[5];
        String[] houseHand = new String[5];
        List<String> cardsList = Arrays.asList(cards);
        Collections.shuffle(cardsList);
        Queue<String> cardQueue = new LinkedList<>(cardsList);

        int handValue = 0;
        int houseValue = 0;

        for(int i = 0; i < 5; i++){

            myHand[i] = cardQueue.poll();

            System.out.println("Dealt: " + myHand[i]);
            System.out.println("Cards remaining: " + cardQueue.size());

            handValue = getHandValue(handValue ,myHand[i]);

            System.out.println("Your current hand is worth: " + handValue);

            if(handValue > 21){
                System.out.print("You're Bust!");
                return;
            }

            if(i < 4) { 
                System.out.print("Do you want to stick or draw another card? ");
                String choice = scanner.nextLine().toLowerCase();
                
                if(choice.equals("s") || choice.equals("stick")) {
                    System.out.println("You chose to stick with " + handValue);
                    break; 
                }
                
            }
        }

        scanner.close();
        
        for(int i = 0; i < 5; i++){

            houseHand[i] = cardQueue.poll();

            System.out.println("House Dealt: " + houseHand[i]);
            System.out.println("Cards remaining: " + cardQueue.size());

            houseValue = getHandValue(houseValue ,houseHand[i]);

            System.out.println("The House hand is worth: " + houseValue);

            if(houseValue > 21){
                System.out.print("House Busts! You Win!");
                return;
            }

            if(i < 4) { 
                
                if(houseValue > handValue) {
                    System.out.println("House wins with " + houseValue);
                    return; 
                } else if ( houseValue == handValue){
                    System.out.println("It's a draw");
                    return; 
                }
                
            }
        }


        System.out.println("It's a draw");


    }


    static int getHandValue(int existingValue, String newCard){

        int newValue = existingValue;

        String cardValue = newCard.substring(0,newCard.indexOf(" "));

        switch(cardValue){
                case "Ace", "King", "Queen", "Jack" -> newValue += 10;
                default -> newValue += Integer.parseInt(cardValue);
            }

        return newValue;

    }

}
