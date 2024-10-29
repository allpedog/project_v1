package com.mobile.project_v1.application.dto.product;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCreateRequestDTO {
    private String name;
    private Double price;
    private MultipartFile image;
}
