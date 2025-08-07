import java.util.ArrayList;

public class ShoppingBasket {

    ArrayList<ShoppingBasketItem> items;

    public ShoppingBasket() {
        items = new ArrayList<>();
    }

    public void add(ShoppingBasketItem item){
        items.add(item);
    }
    
}
