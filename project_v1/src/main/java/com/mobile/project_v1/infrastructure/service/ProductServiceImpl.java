package com.mobile.project_v1.infrastructure.service;

import com.mobile.project_v1.domain.models.Product;
import com.mobile.project_v1.domain.repository.ProductRepository;
import com.mobile.project_v1.domain.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service

public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        product.setId(getGenerationId());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if (existingProduct == null) {
            return null;
        }

        if (product.getName() != null)
        {
            existingProduct.setName(product.getName());
        }
        if (product.getPrice() != null)
        {
            existingProduct.setPrice(product.getPrice());
        }

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        productRepository.delete(existingProduct);


    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    private Integer getGenerationId() {
        UUID uuid = UUID.randomUUID();
        return (int) (uuid.getMostSignificantBits() & 0xFFFFFFFFL);
    }
}
