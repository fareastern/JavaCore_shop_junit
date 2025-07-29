package shop.products.filters;

import shop.products.Product;

public interface ProductFilter {
    boolean matches(Product product);
}