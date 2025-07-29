package shop.products;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {

    @Test
    public void testAddAndRetrieveProductById() {
        ProductCatalog catalog = new ProductCatalog();

        Product product = new Product("p001", "Phone", 699.99, "Electronics", List.of("smartphone", "android"));
        catalog.addProduct(product);

        Product retrieved = catalog.getProductById("p001");

        assertNotNull(retrieved);
        assertEquals("Phone", retrieved.getName());
        assertEquals(699.99, retrieved.getPrice());
    }
}