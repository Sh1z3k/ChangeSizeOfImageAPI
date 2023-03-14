package com.shiz.app.api.api.controller;

import com.shiz.app.api.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


@RestController
public class PictureController {

    private PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService){
        this.pictureService=pictureService;
    }

    @GetMapping("/Picture")
    public String getPicture(@RequestParam Integer id, Integer width, Integer height) throws IOException {
        Image picture = pictureService.getPicture(id);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(picture, 0, 0, width, height, null);
        graphics2D.dispose();
        File outputfile = new File("static/main_resources/resizedimage.png");
        ImageIO.write(resizedImage, "png", outputfile);
        return "<img src=\"main_resources/resizedimage.png\" alt=\"image not found, check the path to the file\" width=\""+width+"\" height=\""+height+"\">";
    }

}
