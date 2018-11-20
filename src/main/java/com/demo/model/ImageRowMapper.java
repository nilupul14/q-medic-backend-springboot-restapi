package com.demo.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ImageRowMapper implements RowMapper<Image>, Serializable {

    public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
        Image image = new Image();
        image.setId(rs.getInt("id"));
        image.setData(rs.getBytes("data"));

        return image;
    }
}
