package com.mobile.project_v1.application.service;

import com.mobile.project_v1.application.dto.product.ProductCreateRequestDTO;
import com.mobile.project_v1.application.dto.product.ProductDTO;
import com.mobile.project_v1.application.dto.product.ProductUpdateRequestDTO;
import com.mobile.project_v1.domain.models.Product;
import com.mobile.project_v1.domain.service.ProductService;
import com.mobile.project_v1.presentation.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductApplicationService {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    public ProductDTO createProduct(ProductCreateRequestDTO productCreateRequestDTO) {
        Product product = productMapper.convertProductCreateRequestDTOToProduct(productCreateRequestDTO);
        log.info("Product {}", product.toString());
        Product productSave = productService.createProduct(product);
        log.info("ProductSave {}", productSave.toString());
        return productMapper.convertProductToProductDTO(productSave);
    }

    public ProductDTO updateProduct(ProductUpdateRequestDTO productUpdateRequestDTO) {
        Product updateProduct = productMapper.covnertProductUpdateRequestDTOToProduct(productUpdateRequestDTO);
        log.info("updateProduct {}", updateProduct.toString());
        Product updateProductSave = productService.updateProduct(updateProduct);
        log.info("updateProductSave {}", updateProductSave.toString());
        return productMapper.convertProductToProductDTO(updateProductSave);
    }

    public void deleteProduct(Integer id) {
        log.info("deleteProduct {}", id);
        productService.deleteProduct(id);
    }


    public List<Product> getList() {
        return productService.getAllProducts();
    }

}
