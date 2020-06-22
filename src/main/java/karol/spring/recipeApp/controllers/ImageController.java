package karol.spring.recipeApp.controllers;

import karol.spring.recipeApp.commands.RecipeCommand;
import karol.spring.recipeApp.services.ImageService;
import karol.spring.recipeApp.services.RecipeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Controller
public class ImageController {
    private final RecipeService recipeService;
    private final ImageService imageService;

    public ImageController(RecipeService recipeService, ImageService imageService) {
        this.recipeService = recipeService;
        this.imageService = imageService;
    }

    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/imageToUploadForm";
    }

    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile")MultipartFile file){

        imageService.saveImageFile(Long.valueOf(id), file);

        return "redirect:/recipe/show/" + id;
    }

    @GetMapping("recipe/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {

        if(recipeService.findCommandById(Long.valueOf(id)).getImage() == null){
            System.out.println("Image not Found!");
        }else {
            RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));

            byte[] byteArrys = new byte[recipeCommand.getImage().length];

            int i = 0;
            for (Byte b : recipeCommand.getImage()) {
                byteArrys[i++] = b;
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArrys);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
