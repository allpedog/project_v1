package com.mobile.project_v1.presentation.mapper;

import com.mobile.project_v1.application.dto.product.ProductCreateRequestDTO;
import com.mobile.project_v1.application.dto.product.ProductDTO;
import com.mobile.project_v1.application.dto.product.ProductUpdateRequestDTO;
import com.mobile.project_v1.domain.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {
    @Autowired
    private ModelMapper modelMapper;

    // chuyển từ CreateProductRequest(dau vao) sang Product Entity
    public Product convertProductCreateRequestDTOToProduct(ProductCreateRequestDTO createProductRequest) {
        return Product.builder()
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .build();
    }

    // chuyen tu Product Entity sang CreateProductResponse (dau ra)
    public ProductDTO convertProductToProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    // chuyen tu UpdateProductRequest (dau vao) sang Product Entity
    public Product covnertProductUpdateRequestDTOToProduct(ProductUpdateRequestDTO productUpdateRequestDTO){
        return Product.builder()
                .id(productUpdateRequestDTO.getId())
                .name(productUpdateRequestDTO.getName())
                .price(productUpdateRequestDTO.getPrice())
                .build();
    }


}
