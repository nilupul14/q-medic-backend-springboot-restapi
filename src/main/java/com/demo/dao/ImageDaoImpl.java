package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Image;
import com.demo.model.ImageRowMapper;

@Transactional
@Repository
public class ImageDaoImpl implements ImageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Image> getAllImages() {
        String query = "SELECT * from doctors";
        RowMapper<Image> rowMapper = new ImageRowMapper();
        List<Image> list = jdbcTemplate.query(query, rowMapper);

        return list;
    }

    @Override
    public Image findImageById(int id) {
        String query = "SELECT * FROM image WHERE id = ?";
        RowMapper<Image> rowMapper = new BeanPropertyRowMapper<Image>(Image.class);
        Image image = jdbcTemplate.queryForObject(query, rowMapper, id);

        return image;
    }

    @Override
    public int addImage(Image image) {
        String query = "INSERT INTO image(id, data) VALUES (?, ?)";
        return jdbcTemplate.update(query, image.getId(), image.getData());
    }

    @Override
    public void updateImage(Image image) {

    }

    @Override
    public void deleteImage(int id) {

    }
}
