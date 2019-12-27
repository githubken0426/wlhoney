package cn.honey.home.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.bean.Photo;
import cn.honey.home.service.album.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class AlbumsController {

    @Autowired
    private AlbumsService albumsService;

    @PostMapping(value = "/albums/create")
    @ResponseStatus(HttpStatus.OK)
    public Album initAlbumsByYear(@RequestBody Album album) {
        return albumsService.saveAlbum(album);
    }

    @GetMapping(value = "/albums/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> findAlbums(@PathVariable("year") Integer year) {
        return albumsService.findAlbumsByYear(year);
    }

    @GetMapping(value = "/album/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album findAlbumById(@PathVariable("id") long id) {
        Set<Photo> photos = new HashSet<>();
        Album album3 = new Album();
        album3.setAlbumName("北京");
        Photo defaultPhoto3 = new Photo();
        defaultPhoto3.setName("bodyImage.jpg");
        photos.add(defaultPhoto3);
        album3.setAlbumPhoto("bodyImage.jpg");
        album3.setPhotos(photos);
        album3.setCreateTime(new Date());
        return album3;
    }
}
