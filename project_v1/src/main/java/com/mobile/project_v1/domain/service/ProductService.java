package com.mobile.project_v1.domain.service;

import com.mobile.project_v1.domain.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Integer id);
    List<Product> getAllProducts();
}
