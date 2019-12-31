package cn.honey.home.web.controller;

import cn.honey.home.enumration.ViewEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value = "/upload/page")
public class UploadPageController extends AbstractController{

    @GetMapping("/single/{albumId}")
    public String albumsUploadPage(@PathVariable("albumId") Integer albumId, Map<String, Object> map) {
        map.put("albumId", albumId);
        return ViewEnum.UPLOAD_ALBUM.view();
    }

    @GetMapping("/multipart/{albumId}")
    public String photoUploadPage(@PathVariable("albumId") Integer albumId, Map<String, Object> map) {
        map.put("albumId", albumId);
        return ViewEnum.UPLOAD_PHOTOS.view();
    }
}
