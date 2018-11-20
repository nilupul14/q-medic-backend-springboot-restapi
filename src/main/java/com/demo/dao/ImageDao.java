package com.demo.dao;

import java.util.List;

import com.demo.model.Image;

public interface ImageDao {

    public List<Image> getAllImages();

    public Image findImageById(int id);

    public int addImage(Image image);

    public void updateImage(Image image);

    public void deleteImage(int id);
}
