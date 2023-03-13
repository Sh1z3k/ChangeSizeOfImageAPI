package com.shiz.app.api.api.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Picture {
    private Image image;
    private String pathToImage;

    private Integer id;

    public Picture(String pathToImage, Integer id) throws IOException {
        this.image = ImageIO.read(new File(pathToImage));
        this.pathToImage = String.valueOf(pathToImage);
        this.id = id;

    }

    public Image getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
