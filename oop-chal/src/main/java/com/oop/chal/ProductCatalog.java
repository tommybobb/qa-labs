package com.oop.chal;

import java.util.ArrayList;
import java.util.List;



public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        products = new ArrayList<>();
        products.add(new Product(1, "Apple iPhone 15", 1500));
        products.add(new Product(2,"Samsung Galaxy S25", 1200));
        products.add(new Product(3,"Sony WH-1000XM5 Headphones", 400));
        products.add(new Product(4,"Dell XPS 13 Laptop", 500));
        products.add(new Product(5,"Nintendo Switch Console", 250));
    }

    public List<Product> getProducts() {
        return products;
    }
}
