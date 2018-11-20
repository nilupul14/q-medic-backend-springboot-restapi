package com.demo.controller;

import com.demo.model.Image;
import com.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping(path = "/image/{id}")
    public Image getImage(@PathVariable int id) {
        return imageService.findImageById(id);
    }

    @RequestMapping(path = "/image/{id}", method = RequestMethod.POST)
    public int addImage(@PathVariable int id, @RequestParam MultipartFile image) throws IOException {
        return imageService.addImage(id, image.getBytes());
    }
}
