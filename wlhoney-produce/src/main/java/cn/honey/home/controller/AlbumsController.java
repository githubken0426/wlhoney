package cn.honey.home.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.bean.Photo;
import cn.honey.home.service.album.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class AlbumsController {

    @Autowired
    private AlbumsService albumsService;

    @GetMapping(value = "/albums/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> healthCheck(@PathVariable("year") Integer year) {
        List<Album> albums = new ArrayList<>();
        Set<Photo> photos = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Album album = new Album();
            album.setId(i);
            album.setAlbumName(i + 1 + "月");
            Photo defaultPhoto = new Photo();
            defaultPhoto.setName("defaultImage.jpeg");
            album.setAlbumPhoto("defaultImage.jpeg");
            photos.add(defaultPhoto);
            album.setPhotos(photos);
            albums.add(album);
        }
        photos = new HashSet<>();
        Album album2 = new Album();
        album2.setAlbumName("北京");
        Photo defaultPhoto2 = new Photo();
        defaultPhoto2.setName("DSCF1023.jpg");
        album2.setAlbumPhoto("DSCF1023.jpg");
        photos.add(defaultPhoto2);
        album2.setPhotos(photos);
        albums.add(album2);

        photos = new HashSet<>();
        Album album3 = new Album();
        album3.setAlbumName("北京");
        Photo defaultPhoto3 = new Photo();
        defaultPhoto3.setName("bodyImage.jpg");
        photos.add(defaultPhoto2);
        album3.setAlbumPhoto("bodyImage.jpg");
        album3.setPhotos(photos);
        albums.add(album3);
        return albums;
    }
}
