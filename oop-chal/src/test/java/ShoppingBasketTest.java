import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.oop.chal.Product;
import com.oop.chal.ProductCatalog;
import com.oop.chal.ShoppingBasket;

public class ShoppingBasketTest {
    private ShoppingBasket basket;
    private ProductCatalog catalog;

    @BeforeEach
    void setUp() {
        basket = new ShoppingBasket(new ArrayList<>(), LocalDateTime.now());
        catalog = new ProductCatalog();
    }

    @Test
    void shouldAddNewItemToEmptyBasket() {
        Product product = catalog.getProducts().get(0); 
        basket.addItem(product, 1);

        assertEquals(1, basket.getItems().size());
        assertEquals(1, basket.getItems().get(0).getQuantity());
        assertEquals(product, basket.getItems().get(0).getProduct());
    }

    @Test
    void shouldUpdateQuantityWhenAddingExistingItem() {
        Product product = catalog.getProducts().get(0);
        
        basket.addItem(product, 1);
        basket.addItem(product, 2);

        assertEquals(1, basket.getItems().size());
        assertEquals(3, basket.getItems().get(0).getQuantity());
    }

    @Test
    void shouldAddMultipleDistinctItems() {
        Product prod1 = catalog.getProducts().get(0);
        Product prod2 = catalog.getProducts().get(1);
        Product prod3 = catalog.getProducts().get(2);

        basket.addItem(prod1, 1);
        basket.addItem(prod2, 2);
        basket.addItem(prod3, 3);

        assertEquals(3, basket.getItems().size());
        
        assertEquals(1, basket.getItems().stream()
            .filter(item -> item.getProduct().equals(prod1))
            .findFirst()
            .get()
            .getQuantity());
            
        assertEquals(2, basket.getItems().stream()
            .filter(item -> item.getProduct().equals(prod2))
            .findFirst()
            .get()
            .getQuantity());
            
        assertEquals(3, basket.getItems().stream()
            .filter(item -> item.getProduct().equals(prod3))
            .findFirst()
            .get()
            .getQuantity());
    }

    @Test
    void shouldDecreaseItemQuanitityFromBasketKeepingOthers(){
        Product prod1 = catalog.getProducts().get(0);
        Product prod2 = catalog.getProducts().get(1);
        Product prod3 = catalog.getProducts().get(2);

        basket.addItem(prod1, 1);
        basket.addItem(prod2, 2);
        basket.addItem(prod3, 3);

        assertEquals(3, basket.getItems().size());
        
        basket.removeItem(prod1);
        basket.removeItem(prod3);

        
        // 0 count of product
        assertEquals(0, basket.getItems().stream()
            .filter(item -> item.getProduct().equals(prod1))
            .count());
            
        // quanitiy of 2
        assertEquals(2, basket.getItems().stream()
            .filter(item -> item.getProduct().equals(prod2))
            .findFirst()
            .get()
            .getQuantity());
        
        assertEquals(2, basket.getItems().stream()
            .filter(item -> item.getProduct().equals(prod3))
            .findFirst()
            .get()
            .getQuantity());


    }

    @Test
    void shouldClearBasketEntirely(){
        Product prod1 = catalog.getProducts().get(0);
        Product prod2 = catalog.getProducts().get(1);
        Product prod3 = catalog.getProducts().get(2);

        basket.addItem(prod1, 1);
        basket.addItem(prod2, 2);
        basket.addItem(prod3, 3);

        assertEquals(3, basket.getItems().size());

        basket.clearBasket();

        assertEquals(0, basket.getItems().size());

    }

    @Test
    void shouldUpdateSavedTimeOfBasket(){
        Product prod1 = catalog.getProducts().get(0);
        Product prod2 = catalog.getProducts().get(1);
        Product prod3 = catalog.getProducts().get(2);

        basket.addItem(prod1, 1);
        basket.addItem(prod2, 2);
        basket.addItem(prod3, 3);

        assertEquals(3, basket.getItems().size());

        basket.saveBasket();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime savedTime = basket.getSavedTime();

        long minutesBetween = java.time.Duration.between(savedTime, now).toMinutes();
        boolean withinTwoMinutes = Math.abs(minutesBetween) <= 2;

        assertEquals(true, withinTwoMinutes);
        assertEquals(true, basket.isPriceValid());

    }

    @Test
    void shouldShowOldBasketAsInvalid(){
        Product prod1 = catalog.getProducts().get(0);
        Product prod2 = catalog.getProducts().get(1);
        Product prod3 = catalog.getProducts().get(2);

        basket.addItem(prod1, 1);
        basket.addItem(prod2, 2);
        basket.addItem(prod3, 3);

        assertEquals(3, basket.getItems().size());

        basket.setSavedTime(LocalDateTime.of(2025, 8, 12, 00, 00));

        assertEquals(false, basket.isPriceValid());

    }
}
