package com.mobile.project_v1.presentation.controller;

import com.mobile.project_v1.application.dto.product.ProductCreateRequestDTO;
import com.mobile.project_v1.application.dto.product.ProductUpdateRequestDTO;
import com.mobile.project_v1.application.service.CloudinaryService;
import com.mobile.project_v1.application.service.ProductApplicationService;
import com.mobile.project_v1.domain.models.Image;
import com.mobile.project_v1.domain.service.ImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductApplicationService productService;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private ImageService imageService;
    @PostMapping()
    public ResponseEntity<?> create(@ModelAttribute @Valid ProductCreateRequestDTO createProductRequest)throws IOException {
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

    @GetMapping("/url/{id}")
    public ResponseEntity<String> getImageUrl(@PathVariable String id) {
        String url = cloudinaryService.getImageUrl(id);
        return ResponseEntity.ok(url);
    }

    @GetMapping("/v1/image")
    public ResponseEntity<byte[]> getImage(@RequestParam Integer id) {
        Image image = imageService.get(id);
        if (image != null) {
            return ResponseEntity.ok()
                    .header("Content-Type", image.getType())
                    .body(image.getImageData());
        }
        return ResponseEntity.notFound().build();
    }

}
