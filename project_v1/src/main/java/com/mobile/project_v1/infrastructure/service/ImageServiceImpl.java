package com.mobile.project_v1.infrastructure.service;

import com.mobile.project_v1.application.service.CloudinaryService;
import com.mobile.project_v1.domain.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private CloudinaryService cloudinaryService;
    @Override
    public String saveImage(MultipartFile file) {
        Map<String, Object> resultMap = cloudinaryService.uploadImage(file);
        String imageUrl = (String) resultMap.get("url");

        return imageUrl;
    }
}
