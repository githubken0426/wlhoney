package cn.honey.home.web.controller;

import cn.honey.home.entity.Album;
import cn.honey.home.entity.Photo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WLHoneyController {

    @GetMapping("/albums")
    public String index(Map<String, Object> map) {
        List<Album> albums = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Album album = new Album();
            album.setAlbumName("天津");
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
        map.put("albums", albums);
        return "albums";
    }
}
