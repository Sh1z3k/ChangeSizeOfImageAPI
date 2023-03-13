package com.shiz.app.api.api.controller;

import com.shiz.app.api.api.model.Picture;
import com.shiz.app.api.api.model.Picture;
import com.shiz.app.api.service.PictureService;
import com.shiz.app.api.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Optional;

@RestController
public class PictureController {

    private PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService){
        this.pictureService=pictureService;
    }

    @GetMapping("/Picture")
    public Image getPicture(@RequestParam Integer id) throws IOException {

        Image picture = pictureService.getPicture(id);
            return picture;
    }


}
