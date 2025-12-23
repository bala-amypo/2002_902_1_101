package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Product;

public interface ProductService {

    Product create(Product product);

    List<Product> getAll();

    Product getById(Long id);
}
