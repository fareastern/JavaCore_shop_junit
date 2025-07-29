package shop.orders;

import shop.products.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Order order;
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("P001", "Apple", 1.5, "Food", List.of("fruit", "fresh"));
        Map<Product, Integer> items = new HashMap<>();
        items.put(product, 3);
        order = new Order("O123", items);
    }

    @Test
    public void testUpdateStatus_changesOrderStatusSuccessfully() {
        // when:
        order.updateStatus(OrderStatus.SHIPPED);

        // then:
        assertEquals(OrderStatus.SHIPPED, order.getStatus());
    }
}
