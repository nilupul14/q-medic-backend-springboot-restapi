package com.demo.service;

import java.util.List;

import com.demo.model.Image;

public interface ImageService {

    public List<Image> getAllImages();

    public Image findImageById(int id);

    public Image addImage(Image image);

    public void updateImage(Image image);

    public void deleteImage(int id);

    int addImage(int id, byte[] bytes);
}
