package com.mobile.project_v1.application.dto.product;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequestDTO {
    private Integer id;
    private String name;
    private Double price;
    private MultipartFile image;
}
