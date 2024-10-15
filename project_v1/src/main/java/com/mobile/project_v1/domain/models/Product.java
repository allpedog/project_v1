package com.mobile.project_v1.domain.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Integer id;
    private String name;
    private Double price;
}
