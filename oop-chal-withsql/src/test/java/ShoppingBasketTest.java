import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import com.oop.chal.entity.ShoppingBasket;

public class ShoppingBasketTest {
    private ShoppingBasket basket;

    @BeforeEach
    void setUp() {
        basket = new ShoppingBasket(new ArrayList<>(), LocalDateTime.now());
    }

}
