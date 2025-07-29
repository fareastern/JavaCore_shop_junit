package shop;

import shop.orders.Order;
import shop.products.Product;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ShopSystemTest {

    private ShopSystem shopSystem;

    @BeforeEach
    public void setUp() {
        shopSystem = new ShopSystem();
    }

    @Test
    public void testUserRegistrationAndLogin() {
        boolean registered = shopSystem.registerUser("vasya", "12345");
        boolean loginSuccess = shopSystem.login("vasya", "12345");

        assertTrue(registered);
        assertTrue(loginSuccess);
        assertNotNull(shopSystem.getCurrentUser());
    }

    @Test
    public void testAddToCartAndPlaceOrder() {
        shopSystem.registerUser("masha", "pw");
        shopSystem.login("masha", "pw");

        Product product = shopSystem.getProductCatalog().getAllProducts().getFirst();
        User currentUser = shopSystem.getCurrentUser();
        currentUser.getShoppingCart().addProduct(product, 1);

        shopSystem.placeOrder();
        List<Order> orders = currentUser.getOrderHistory();

        assertEquals(1, orders.size());

        Order order = orders.getFirst();
        Map<Product, Integer> items = order.getItems();

        assertEquals(1, items.size());
        assertTrue(items.containsKey(product));
        assertEquals(1, items.get(product));
    }

    @Test
    public void testEmptyCart_noOrderCreated() {
        shopSystem.registerUser("oleg", "secret");
        shopSystem.login("oleg", "secret");

        shopSystem.placeOrder();
        List<Order> orders = shopSystem.getCurrentUser().getOrderHistory();

        assertEquals(0, orders.size());
    }
}
