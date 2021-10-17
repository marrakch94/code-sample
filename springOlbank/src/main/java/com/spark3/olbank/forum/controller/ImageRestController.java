package com.spark3.olbank.forum.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;



@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/image")
public class ImageRestController {

    @GetMapping(value = "/", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getImageWithMediaType() throws IOException {
        String imageUrl = "http://localhost:8082/images/C3PO-icon_34503.png";
        URL url = new URL(imageUrl);
        //= url.openStream();
        InputStream in = url.openStream();
        //getClass().getResourceAsStream("/images/cinemaIcon.png");

        return IOUtils.toByteArray(in);
    }

    @GetMapping("/x")
    public String getHello() throws IOException {

        return "hello";
    }
    @GetMapping(value = "/{nom}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getPostImage(@PathVariable ("nom") String nom) throws IOException {

        File initialFile = new File("src/main/webapp/WEB-INF/images/"+nom);
        InputStream targetStream = new FileInputStream(initialFile);

        return IOUtils.toByteArray(targetStream);
    }
    @PostMapping(path = "/skellige", produces = "application/json")
    @ResponseBody
    public Map<String,String> getFilmPoster()  {
        Map<String,String> values = new HashMap<String,String>();
        values.put("url", "http://localhost:8082/image/C3PO-icon_34503.png");
        return values;
    }

}