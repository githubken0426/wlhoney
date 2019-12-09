package cn.honey.home.web.controller;

import cn.honey.home.bean.Album;
import cn.honey.home.bean.Photo;
import cn.honey.home.web.GlobalProperties;
import cn.honey.home.web.enumration.ViewEnum;
import cn.honey.home.web.util.EurekaInstanceUtils;
import com.netflix.appinfo.InstanceInfo;
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

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class WLHoneyController {
    private static final Logger logger = LogManager.getLogger();

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GlobalProperties globalProperties;

    @GetMapping("/")
    public String index(Map<String, Object> map) {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        return "redirect:/albums/" + year;
    }

    @GetMapping("/albums/{year}")
    public String albums(@PathVariable("year") Integer year, Map<String, Object> map) {
        Application serverApplication = eurekaClient.getApplication("WLHONEY-SERVER");
        logger.info("Eureka Server Application instance: {}", serverApplication.getName());
        Application application = eurekaClient.getApplication("WLHONEY-PRODUCE");
        String serviceUrl = EurekaInstanceUtils.getEurekaServiceURI(application, "wlhoney-produce:8181") + "albums" + File.separator + year;
        logger.info("Get service url from eureka-client : {}", serviceUrl);
        String ut = "http://WLHONEY-PRODUCE:8181/albums/2019";
        List<Album> albums = restTemplate.getForObject(ut, ArrayList.class);
        map.put("albums", albums);
        return ViewEnum.ALBUMS.view();
    }

    @GetMapping("/photos/{albumId}")
    public String photos(@PathVariable("albumId") int albumId, Map<String, Object> map) {
        Application application = eurekaClient.getApplication("WLHONEY-PRODUCE");
        String serviceUrl = EurekaInstanceUtils.getEurekaServiceURI(application, "wlhoney-produce:8181") + "photos" + File.separator + albumId;
        serviceUrl = "http://WLHONEY-PRODUCE:8181/photos/2019";
        List<Photo> photos = restTemplate.getForObject(serviceUrl, ArrayList.class);
        map.put("photos", photos);
        return ViewEnum.PHOTO_CONVERFLOW.view();
    }
}
