package cn.honey.home.web.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.bean.Photo;
import cn.honey.home.util.PropertyUtils;
import cn.honey.home.web.GlobalProperties;
import cn.honey.home.web.enumration.ViewEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WLHoneyController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GlobalProperties globalProperties;

    @GetMapping("/")
    public String index(Map<String, Object> map) {
        return "redirect:/albums";
    }

    @GetMapping("/albums")
    public String albums(Map<String, Object> map) {
//        String photoServiceUrl = PropertyUtils.getString("microservice.album.root") +"/2019/albums";
        String photoServiceUrl = "http://WLHONEY-PRODUCE:8182/2019/albums";

        List<Album> albums = restTemplate.getForObject(photoServiceUrl, ArrayList.class);
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
