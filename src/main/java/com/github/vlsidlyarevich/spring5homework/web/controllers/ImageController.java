package com.github.vlsidlyarevich.spring5homework.web.controllers;

import com.github.vlsidlyarevich.spring5homework.domain.services.ImageService;
import com.github.vlsidlyarevich.spring5homework.domain.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(id));

        return "recipe/imageuploadform";
    }

    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {
        imageService.saveImageFile(id, file);

        return "redirect:/recipe/" + id + "/show";
    }

//    @GetMapping("recipe/{id}/recipeimage")
//    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
//        RecipeCommand recipeCommand = recipeService.findCommandById(id).block();
//
//        if (recipeCommand.getImage() != null) {
//            byte[] byteArray = new byte[recipeCommand.getImage().length];
//            int i = 0;
//
//            for (Byte wrappedByte : recipeCommand.getImage()) {
//                byteArray[i++] = wrappedByte; //auto unboxing
//            }
//
//            response.setContentType("image/jpeg");
//            InputStream is = new ByteArrayInputStream(byteArray);
//            IOUtils.copy(is, response.getOutputStream());
//        }
//    }
}
