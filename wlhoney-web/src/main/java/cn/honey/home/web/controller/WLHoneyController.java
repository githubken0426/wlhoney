package cn.honey.home.web.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.bean.Photo;
import cn.honey.home.enumration.AlbumNameEnum;
import cn.honey.home.enumration.ViewEnum;
import com.netflix.discovery.shared.Application;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class WLHoneyController extends AbstractController {
    final String DEFAULT_PHOTO = "bodyImage.jpg";

    @GetMapping("/")
    public String index() {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        return "redirect:/albums/" + year;
    }

    @GetMapping("/albums/{year}")
    public String albums(@PathVariable("year") Integer year, Map<String, Object> map) {
        Application serverApplication = eurekaClient.getApplication("WLHONEY-SERVER");
        logger.info("Eureka Server Application instance: {}", serverApplication.getName());
        String serviceUrl = this.getProduceUrl();
        logger.info("Get service url from eureka-client : {}", serviceUrl);
        List<Album> albums = restTemplate.getForObject(serviceUrl + "produce/albums/" + year, ArrayList.class);
        //init albums by year
        if (CollectionUtils.isEmpty(albums)) {
            for (AlbumNameEnum albumEnum : AlbumNameEnum.values()) {
                Album album = new Album();
                album.setYear(year);
                album.setAlbumName(albumEnum.album());
                album.setAlbumPhoto(DEFAULT_PHOTO);
                album.setDescription(albumEnum.value());
                album.setFlag("Y");
                albums.add(album);
            }
            restTemplate.postForObject(serviceUrl + "produce/albums/initial", albums, List.class);
        }
        map.put("albums", albums);
        map.put("year", year);
        return ViewEnum.ALBUMS.view();
    }

    @GetMapping("/photos/{albumId}")
    public String photos(@PathVariable("albumId") Integer albumId, Map<String, Object> map) {
        String serviceUrl = this.getProduceUrl();
        Album album = restTemplate.getForObject(serviceUrl + "produce/albums/album/{1}", Album.class, albumId);
        if (album == null) {
            Photo defaultPhoto = new Photo();
            defaultPhoto.setName(DEFAULT_PHOTO);
            map.put("photos", Arrays.asList(defaultPhoto));
            return "redirect:/";
        }
        if (CollectionUtils.isEmpty(album.getPhotos())) {
            Photo defaultPhoto = new Photo();
            defaultPhoto.setName(DEFAULT_PHOTO);
            album.getPhotos().add(defaultPhoto);
        }
        map.put("albumId", albumId);
        map.put("photos", album.getPhotos());
        AlbumNameEnum albumEnum = AlbumNameEnum.valueOf(album.getAlbumName().toUpperCase());
        return albumEnum.viewEnum().view();
    }
}
