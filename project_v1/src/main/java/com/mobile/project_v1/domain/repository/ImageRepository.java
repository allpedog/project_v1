package com.mobile.project_v1.domain.repository;

import com.mobile.project_v1.domain.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
