package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository{

    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", 7000000, "Mau trang", "Iphone"));
        products.put(2, new Product(2, "Samsung", 6000000, "Mau xanh", "Samsung"));
        products.put(3, new Product(3, "Oppo", 8000000, "Mau hong", "Oppo"));
        products.put(4, new Product(4, "Iphone X", 9000000, "Mau xam", "Iphone"));
        products.put(5, new Product(5, "Vmart", 5000000, "Mau do", "Vmart"));
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}
