package cn.honey.home.controller;

import cn.honey.home.bean.Photo;
import cn.honey.home.service.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class PhotosController {

    @Autowired
    private PhotoService photoService;

    @GetMapping(value = "/photos/{albumsId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Photo> healthCheck(@PathVariable("albumsId") Long albumsId) {
        List<Photo> photos =new ArrayList<>();
        Photo defaultPhoto = new Photo();
        defaultPhoto.setName("bodyImage.jpg");
        Photo defaultPhoto2 = new Photo();
        defaultPhoto2.setName("xiaozhao.jpg");
        Photo defaultPhoto3 = new Photo();
        defaultPhoto3.setName("wlhoney.jpg");
        photos.add(defaultPhoto);
        photos.add(defaultPhoto2);
        photos.add(defaultPhoto3);
        return photos;
    }
}
