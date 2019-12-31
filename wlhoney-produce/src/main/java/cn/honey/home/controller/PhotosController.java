package cn.honey.home.controller;

import cn.honey.home.bean.Photo;
import cn.honey.home.service.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/produce/photos", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PhotosController {

    @Autowired
    private PhotoService photoService;

    @GetMapping(value = "/{albumId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Photo> findPhotosByAlbumId(@PathVariable("albumId") Long albumId) {
        return photoService.findPhotosByAlbumId(albumId);
    }

    @GetMapping(value = "/photo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Photo findPhotosById(@PathVariable("id") Long id) {
        return photoService.findPhotoById(id);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.OK)
    public Photo savePhoto(@RequestBody Photo photo) {
        return photoService.savePhoto(photo);
    }
}
