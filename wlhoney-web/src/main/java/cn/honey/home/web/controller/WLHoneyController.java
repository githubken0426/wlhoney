package cn.honey.home.web.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.bean.Photo;
import cn.honey.home.web.GlobalProperties;
import cn.honey.home.web.enumration.ViewEnum;
import cn.honey.home.web.util.EurekaInstanceUtils;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class WLHoneyController extends AbstractController {

    @GetMapping("/")
    public String index() {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        return "redirect:/albums/" + year;
    }

    @GetMapping("/albums/{year}")
    public String albums(@PathVariable("year") Integer year, Map<String, Object> map) {
        Application serverApplication = eurekaClient.getApplication("WLHONEY-SERVER");
        logger.info("Eureka Server Application instance: {}", serverApplication.getName());
        Application application = eurekaClient.getApplication("WLHONEY-PRODUCE");
        String serviceUrl = EurekaInstanceUtils.getEurekaServiceURI(application, "wlhoney-produce:8181") + "albums/" + year;
        logger.info("Get service url from eureka-client : {}", serviceUrl);
        List<Album> albums = restTemplate.getForObject(serviceUrl, ArrayList.class);
        map.put("albums", albums);
        map.put("year", year);
        return ViewEnum.ALBUMS.view();
    }

    @GetMapping("/photos/{albumId}")
    public String photos(@PathVariable("albumId") Integer albumId, Map<String, Object> map) {
        Application application = eurekaClient.getApplication("WLHONEY-PRODUCE");
        String serviceUrl = EurekaInstanceUtils.getEurekaServiceURI(application, "wlhoney-produce:8181") + "photos/" + albumId;
        List<Photo> photos = restTemplate.getForObject(serviceUrl, ArrayList.class);
        map.put("photos", photos);
        return ViewEnum.PHOTO_CONVERFLOW.view();
    }
}
