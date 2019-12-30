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
@RequestMapping(value = "/produce/albums", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AlbumsController {

    @Autowired
    private AlbumsService albumsService;

    @PostMapping(value = "/initial")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> initAlbumsByYear(@RequestBody List<Album> albums) {
        return albumsService.saveAllAlbums(albums);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.OK)
    public Album saveAlbum(@RequestBody Album albums) {
        return albumsService.saveAlbum(albums);
    }

    @GetMapping(value = "/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> findAlbums(@PathVariable("year") Integer year) {
        return albumsService.findAlbumsByYear(year);
    }

    @GetMapping(value = "/album/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album findAlbumById(@PathVariable("id") long id) {
        return albumsService.findAlbumById(id);
    }
}
