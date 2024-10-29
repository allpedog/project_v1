package com.mobile.project_v1.application.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dgmi3soo9");
        config.put("api_key", "539843135341172");
        config.put("api_secret", "Kwstu1T-9Lw-GQ0IV5dnhz_Ue7k");
        cloudinary = new Cloudinary(config);
    }

    // tải hình ảnh lên cloud
    public Map uploadImage(MultipartFile file) {
        try {
            File convertFile = convert(file);
            Map result = cloudinary.uploader().upload(convertFile, ObjectUtils.emptyMap());
            if (!convertFile.delete()) {
                return null;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // xóa ảnh trên cloud
    public Map deleteImage(String id) throws IOException{
        try {
            return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // lấy url ảnh từ cloud
    public String getImageUrl(String id) {
        return cloudinary.url().generate(id);
    }

    // lấy id ảnh từ url
    public String getImageId(String url) {
        return url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
    }

    // lấy id ảnh từ url
    public String getImageIdFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
    }

    // chuyển đổi ảnh thành file
    public File convert(MultipartFile multipartFile) throws IOException {
        try {
            File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(multipartFile.getBytes());
            fo.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
