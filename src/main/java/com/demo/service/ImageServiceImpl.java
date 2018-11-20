package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ImageDaoImpl;
import com.demo.model.Image;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDaoImpl imageDao;

    @Override
    public List<Image> getAllImages() {
        return imageDao.getAllImages();
    }

    @Override
    public Image findImageById(int id) {
        return imageDao.findImageById(id);
    }

    @Override
    public Image addImage(Image doctor) {
        imageDao.addImage(doctor);
        return doctor;
    }

    @Override
    public void updateImage(Image doctor) {
        imageDao.updateImage(doctor);
    }

    @Override
    public void deleteImage(int id) {
        imageDao.deleteImage(id);
    }

    @Override
    public int addImage(int id, byte[] data) {
        Image image = new Image();
        image.setId(id);
        image.setData(data);

        return imageDao.addImage(image);
    }
}
