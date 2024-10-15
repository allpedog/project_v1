package com.mobile.project_v1.presentation.controller;

import com.mobile.project_v1.application.dto.product.ProductCreateRequestDTO;
import com.mobile.project_v1.application.dto.product.ProductUpdateRequestDTO;
import com.mobile.project_v1.application.service.ProductApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductApplicationService productService;
    @PostMapping()
    public ResponseEntity<?> create(@ModelAttribute @Valid ProductCreateRequestDTO createProductRequest) {
        return new ResponseEntity<>(productService.createProduct(createProductRequest), HttpStatus.CREATED);
    }

    @PatchMapping()
    public ResponseEntity<String> update(@ModelAttribute @Valid ProductUpdateRequestDTO updateProductRequest) {
        productService.updateProduct(updateProductRequest);
        return ResponseEntity.ok("cap nhat thanh cong");
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("xoa thanh cong");
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(productService.getList());
    }
}
