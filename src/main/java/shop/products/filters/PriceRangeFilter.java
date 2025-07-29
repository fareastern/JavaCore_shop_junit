package shop.products.filters;

import shop.products.Product;

public class PriceRangeFilter implements ProductFilter {
    private final double minPrice;
    private final double maxPrice;

    public PriceRangeFilter(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean matches(Product product) {
        return product.getPrice() >= minPrice && product.getPrice() <= maxPrice;
    }
}