package cn.honey.home.web.controller;

import cn.honey.home.web.enumration.ViewEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class UploadController {
    private static final Logger logger = LogManager.getLogger();

    @GetMapping("/upload/single-page/{albumsId}")
    public String albumsUploadPage(@PathVariable("albumsId") Integer albumsId, Map<String, Object> map) {
        map.put("albumsId", albumsId);
        return ViewEnum.UPLOAD_SINGLE.view();
    }

    @GetMapping("/upload/multipart-page/{albumsId}")
    public String photoUploadPage(@PathVariable("albumsId") Integer albumsId, Map<String, Object> map) {
        map.put("albumsId", albumsId);
        return ViewEnum.UPLOAD_MULTIPART.view();
    }

    @PostMapping("/upload/{albumsId}")
    public String upload(@PathVariable("albumsId") Integer albumsId, Map<String, Object> map) {

        return ViewEnum.UPLOAD_MULTIPART.view();
    }
}
