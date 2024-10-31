package com.mobile.project_v1.domain.service;

import com.mobile.project_v1.domain.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String saveImage(MultipartFile file);
    Image get(Integer id);
    Image addImage(MultipartFile image) throws IOException;
}
