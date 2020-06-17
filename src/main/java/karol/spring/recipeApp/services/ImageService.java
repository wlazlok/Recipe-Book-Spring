package karol.spring.recipeApp.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public interface ImageService {
    void saveImageFile(Long recipeId, MultipartFile file);
}
