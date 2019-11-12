package cn.honey.home.web.controller;

import cn.honey.home.entity.Album;
import cn.honey.home.entity.Photo;
import cn.honey.home.web.enumration.ViewEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WLHoneyController {
    @GetMapping("/")
    public String index(Map<String, Object> map) {
        return "redirect:/albums";
    }

    @GetMapping("/albums")
    public String albums(Map<String, Object> map) {
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
        map.put("albums", albums);
        return ViewEnum.ALBUMS.view();
    }

    @GetMapping("/{albumId}/photos")
    public String photos(@PathVariable("albumId") int albumId, Map<String, Object> map) {
        List<Photo> photos = new ArrayList<>();
        Photo defaultPhoto = new Photo();
        defaultPhoto.setName("bodyImage.jpg");
        Photo defaultPhoto2 = new Photo();
        defaultPhoto2.setName("xiaozhao.jpg");
        Photo defaultPhoto3 = new Photo();
        defaultPhoto3.setName("wlhoney.jpg");

        photos.add(defaultPhoto);
        photos.add(defaultPhoto2);
        photos.add(defaultPhoto3);
        map.put("photos", photos);
        map.put("defaultPhoto", defaultPhoto);
        return ViewEnum.PHOTO_CONVERFLOW.view();
    }
}
