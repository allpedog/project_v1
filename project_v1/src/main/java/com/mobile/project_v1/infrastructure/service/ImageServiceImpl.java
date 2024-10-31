package com.mobile.project_v1.infrastructure.service;

import com.mobile.project_v1.application.service.CloudinaryService;
import com.mobile.project_v1.domain.models.Image;
import com.mobile.project_v1.domain.repository.ImageRepository;
import com.mobile.project_v1.domain.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private ImageRepository imageRepository;
    @Value("${image.service.url}")
    private String imageServiceUrl;
    @Override
    public String saveImage(MultipartFile file) {
        Map<String, Object> resultMap = cloudinaryService.uploadImage(file);
        String imageUrl = (String) resultMap.get("url");

        return imageUrl;
    }

    @Override
    public Image get(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image addImage(MultipartFile image) throws IOException {
        Image newImage = Image.builder()
                .id(getGenerationId())
                .name(image.getOriginalFilename())
                .type(image.getContentType())
                .imageData(image.getBytes())
                .build();
        newImage.setUrl(imageServiceUrl+"image?id=" + newImage.getId());
        return imageRepository.save(newImage);
    }

    private Integer getGenerationId() {
        UUID uuid = UUID.randomUUID();
        return (int) (uuid.getMostSignificantBits() & 0xFFFFFFFFL);
    }
}
