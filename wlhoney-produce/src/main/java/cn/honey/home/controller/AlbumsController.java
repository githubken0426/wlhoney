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
@RequestMapping(value = "/albums", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AlbumsController {

    @Autowired
    private AlbumsService albumsService;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> initAlbumsByYear(@RequestBody List<Album> albums) {
        return albumsService.saveAllAlbums(albums);
    }

    @GetMapping(value = "/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> findAlbums(@PathVariable("year") Integer year) {
        return albumsService.findAlbumsByYear(year);
    }

}
