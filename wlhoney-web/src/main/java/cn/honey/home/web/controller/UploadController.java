package cn.honey.home.web.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.bean.Photo;
import cn.honey.home.result.ApiResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

@RestController
@RequestMapping(value = "/upload")
public class UploadController extends AbstractController {

    @PostMapping("/album/{albumId}")
    public ApiResult<Integer> uploadAlbums(@PathVariable("albumId") Long albumId,
                                           @RequestParam("file") MultipartFile multiFiles,
                                           @RequestParam("description") String description) {
        logger.info("albums id: {}", albumId);
        ApiResult<Integer> result = new ApiResult();
        try {
            String serviceUrl = this.getProduceUrl();
            Album album = restTemplate.getForObject(serviceUrl + "produce/albums/album/{1}", Album.class, albumId);
            if (album == null) {
                result.setCode("1");
                result.setMessage(global.getErrorOperation());
                return result;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(album.getCreateTime());
            String fileName = album.getId() + "_" + System.currentTimeMillis() + ".jpg";
            String filePath = calendar.get(Calendar.YEAR) + "/" + album.getAlbumName() + "/";
            album.setAlbumPhoto(filePath + fileName);
            album.setDescription(description);
            restTemplate.postForObject(serviceUrl + "produce/albums/save", album, Album.class);
            this.saveFiles(global.getFileUploadPath() + filePath, fileName, multiFiles);
            result.setCode("0");
            result.setMessage(global.getSuccessOperation());
        } catch (IOException e) {
            e.printStackTrace();
            result.setCode("1");
            result.setMessage(global.getErrorOperation());
        }
        return result;
    }

    @PostMapping("/photo/{albumId}")
    public ApiResult<Integer> uploadPhotos(@PathVariable("albumId") Long albumId,
                                           @RequestParam("file") MultipartFile multiFiles, Photo photo) {
        logger.info("photo albums id: {}", albumId);
        ApiResult<Integer> result = new ApiResult();
        try {
            String serviceUrl = this.getProduceUrl();
            Album album = restTemplate.getForObject(serviceUrl + "produce/albums/album/{1}", Album.class, albumId);
            if (album == null) {
                result.setCode("1");
                result.setMessage(global.getErrorOperation());
                return result;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(album.getCreateTime());
            String fileName = album.getId() + "_" + System.currentTimeMillis() + ".jpg";
            String filePath = calendar.get(Calendar.YEAR) + "/" + album.getAlbumName() + "/";
            this.saveFiles(global.getFileUploadPath() + filePath, fileName, multiFiles);
            photo.setName(filePath + fileName);
            photo.setAlbum(album);
            photo.setFlag("Y");
            restTemplate.postForObject(serviceUrl + "produce/photos/save", photo, Photo.class);
            result.setCode("0");
            result.setMessage(global.getSuccessOperation());
        } catch (IOException e) {
            e.printStackTrace();
            result.setCode("1");
            result.setMessage(global.getErrorOperation());
        }
        return result;
    }

    private void saveFiles(String filePath, String fileName, MultipartFile multiFiles) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Path savePath = Paths.get(filePath + fileName);
        byte[] bytes = multiFiles.getBytes();
        Files.write(savePath, bytes);
    }
}
