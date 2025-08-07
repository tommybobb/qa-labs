
import java.util.LinkedList;
import java.util.Queue;

public class Program2{
    static Queue<ShoppingBasket> baskets = new LinkedList<ShoppingBasket>();

    static {
        ShoppingBasket basket1 = new ShoppingBasket();
        basket1.items.add(new ShoppingBasketItem("Apple", 5, 1.50));
        basket1.items.add(new ShoppingBasketItem("Bread", 2, 2.99));
        baskets.offer(basket1);

        ShoppingBasket basket2 = new ShoppingBasket();
        basket2.items.add(new ShoppingBasketItem("Milk", 1, 3.49));
        basket2.items.add(new ShoppingBasketItem("Eggs", 12, 4.25));
        basket2.items.add(new ShoppingBasketItem("Cheese", 1, 5.99));
        baskets.offer(basket2);

        
        ShoppingBasket basket3 = new ShoppingBasket();
        basket3.items.add(new ShoppingBasketItem("Bananas", 6, 0.89));
        baskets.offer(basket2);

    }

    public static void main(String[] args) {

        processBaskets();

    }   


    static void processBaskets(){

        System.out.println("Processing Baskets - To Process: " + baskets.size());
        System.out.println("------------ ");

        int totalBaskets = 0;
        int currentBasket = 1;

        while(!baskets.isEmpty()){

            System.out.println("Processing Basket " + currentBasket);

            ShoppingBasket b = baskets.poll();

            for(ShoppingBasketItem i : b.items){
                System.out.println(i.getDetails());
            }


            System.out.println("Basket Processed");
            System.out.println("Baskets left in queue " + baskets.size());
            System.out.println("--------------------------");
            totalBaskets++;
            currentBasket++;

        }

        System.out.println("All baskets processed! Total Processed: " + totalBaskets);

    }

}
