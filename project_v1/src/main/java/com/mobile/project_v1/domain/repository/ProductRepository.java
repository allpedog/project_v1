package com.mobile.project_v1.domain.repository;

import com.mobile.project_v1.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
