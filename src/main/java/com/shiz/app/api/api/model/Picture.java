package com.shiz.app.api.api.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Picture {
    private Image image;
    private String pathToImage;

    public Picture(URL pathToImage) throws IOException, URISyntaxException {
        this.image = ImageIO.read(new File(pathToImage.toURI()));
        this.pathToImage = String.valueOf(pathToImage);

    }

    public Image getImage() {
        return image;
    }
}
