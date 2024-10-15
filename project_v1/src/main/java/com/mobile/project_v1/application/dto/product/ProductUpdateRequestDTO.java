package com.mobile.project_v1.application.dto.product;

import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequestDTO {
    private Integer id;
    private String name;
    private Double price;
}
