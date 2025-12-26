package com.example.demo.service;

import com.example.demo.model.Product;
import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product getById(Long id);

    List<Product> getAll();
}
