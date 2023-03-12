package com.shiz.app.api.service;


import com.shiz.app.api.api.model.Picture;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PictureService {


    private List<Picture> picsList;

    public PictureService() throws IOException, URISyntaxException {
        picsList = new ArrayList<>();



        Picture pic1 = new Picture(getClass().getClassLoader().getResource("res/pic1.jpg"));
        Picture pic2 = new Picture(getClass().getClassLoader().getResource("res/pic2.jpg"));
        Picture pic3 = new Picture(getClass().getClassLoader().getResource("res/pic3.jpg"));
        picsList.addAll(Arrays.asList(pic1, pic2, pic3));
    }
    public Optional<Picture> getPicture(String PathToPic) throws IOException {

        Optional optional = Optional.empty();
        for (Picture pic:picsList)
            if(pic.getImage() == ImageIO.read(new File(PathToPic)))
            {
                optional = Optional.of(pic);
                return optional;
            }

        return optional;
    }
}
