package com.shiz.app.api.api.controller;

import com.shiz.app.api.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class PictureController {

    private PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) throws MalformedURLException {
        this.pictureService=pictureService;
    }






    @ResponseBody
    @RequestMapping(value = "/Picture", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    @Cacheable("static")
    public byte[] getPicture(@RequestParam Integer id, Integer width, Integer height) throws IOException {
        Image picture = pictureService.getPicture(id);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(picture, 0, 0, width, height, null);
        graphics2D.dispose();
            File outputfile = new File("static/main_resources/resizedimage.png");
        ImageIO.write(resizedImage, "png", outputfile);

        URL url = new URL("http://localhost:8080/static/main_resources/resizedimage.png");
        InputStream in = new BufferedInputStream(url.openStream());
        return FileCopyUtils.copyToByteArray(in);


       // return "<img src=\"static/main_resources/resizedimage.png\" alt=\"image not found, check the path to the file\" width=\""+width+"\" height=\""+height+"\">";
    }

}
