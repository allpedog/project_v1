package com.mobile.project_v1.application.dto.product;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO {
    private Integer id;
    private String name;
    private Double price;
}
