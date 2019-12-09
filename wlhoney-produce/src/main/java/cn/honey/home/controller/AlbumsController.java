package cn.honey.home.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.bean.Photo;
import cn.honey.home.service.album.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class AlbumsController {

    @Autowired
    private AlbumsService albumsService;

    @GetMapping(value = "/albums/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> healthCheck(@PathVariable("year") String year) {
        List<Album> albums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Album album = new Album();
            album.setId(i);
            album.setAlbumName(i + 1 + "月");
            Photo defaultPhoto = new Photo();
            defaultPhoto.setName("defaultImage.jpeg");
            album.setDefaultPhoto(defaultPhoto);
            albums.add(album);
        }
        Album album2 = new Album();
        album2.setAlbumName("北京");
        Photo defaultPhoto2 = new Photo();
        defaultPhoto2.setName("DSCF1023.jpg");
        album2.setDefaultPhoto(defaultPhoto2);
        albums.add(album2);

        Album album3 = new Album();
        album3.setAlbumName("北京");
        Photo defaultPhoto3 = new Photo();
        defaultPhoto3.setName("bodyImage.jpg");
        album3.setDefaultPhoto(defaultPhoto3);
        albums.add(album3);
        return albums;
    }
}
