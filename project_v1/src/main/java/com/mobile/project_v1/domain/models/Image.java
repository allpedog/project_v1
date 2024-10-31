package com.mobile.project_v1.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Image {
    @Id
    private Integer id;
    private String name;
    private String type;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;
    private String url;
}
