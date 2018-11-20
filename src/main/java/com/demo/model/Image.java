package com.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "image")
public class Image implements Serializable {

    @Id
    private Integer id;
    @Lob
    private byte[] data;

    public Image() {
        //
    }

    public Image(Integer id, byte[] data) {
        super();
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
