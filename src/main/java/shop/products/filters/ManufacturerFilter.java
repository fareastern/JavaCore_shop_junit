package shop.products.filters;

import shop.products.Product;

public class ManufacturerFilter implements ProductFilter {
    private final String manufacturer;

    public ManufacturerFilter(String manufacturer) {
        this.manufacturer = manufacturer.toLowerCase();
    }

    @Override
    public boolean matches(Product product) {
        return product.getManufacturer().toLowerCase().contains(manufacturer);
    }
}