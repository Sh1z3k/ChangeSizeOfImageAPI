package com.shiz.app.api.service;


import com.shiz.app.api.api.model.Picture;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

@Service
public class PictureService {


    private List<Picture> picsList;

    public PictureService() throws IOException, URISyntaxException {
        picsList = new ArrayList<>();


        //File myObj = new File("TUTAJ.txt");
        // myObj.createNewFile();


        Picture pic1 = new Picture("static/main_resources/pic1.png", 1);
        Picture pic2 = new Picture("static/main_resources/pic2.png", 2);
        picsList.addAll(Arrays.asList(pic1, pic2));
    }


    public Image getPicture(Integer id){

        for (Picture pic:picsList)
            if(id == pic.getId()) {
                return pic.getImage();
            }
        return null;
    }
}
