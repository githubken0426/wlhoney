package cn.honey.home.web.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.result.ApiResult;
import cn.honey.home.web.util.EurekaInstanceUtils;
import com.netflix.discovery.shared.Application;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.UUID;

@RestController
public class UploadController extends AbstractController {

    @PostMapping("/upload/{albumsId}")
    public ApiResult<Integer> upload(@PathVariable("albumsId") Integer albumsId,
                                     @RequestParam("file") MultipartFile multiFiles) {
        logger.info("albums id: {}", albumsId);
        ApiResult<Integer> result = new ApiResult();
        try {
            Application application = eurekaClient.getApplication("WLHONEY-PRODUCE");
            String serviceUrl = EurekaInstanceUtils.getEurekaServiceURI(application, "wlhoney-produce:8181") + "album/{1}";
            Album album = restTemplate.getForObject(serviceUrl, Album.class, albumsId);
            Calendar calendar = Calendar.getInstance();
            if (album != null) {
                calendar.setTime(album.getCreateTime());
            }
            String filePath = global.getFileUploadPath() + calendar.get(Calendar.YEAR) +
                    File.separator + calendar.get(Calendar.MONTH) + File.separator;
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }

            String fileName = filePath + UUID.randomUUID() + ".jpg";
            Path savePath = Paths.get(fileName);
            byte[] bytes = multiFiles.getBytes();
            Files.write(savePath, bytes);

            result.setCode("0");
            result.setMessage(global.getSuccessOperation());
        } catch (IOException e) {
            e.printStackTrace();
            result.setCode("1");
            result.setMessage(global.getErrorOperation());
        }
        return result;
    }

}
