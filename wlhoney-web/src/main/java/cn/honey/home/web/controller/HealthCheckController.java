package cn.honey.home.web.controller;

import cn.honey.home.web.util.EurekaInstanceUtils;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class HealthCheckController {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/health-check", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String healthCheck() {
        Application application = eurekaClient.getApplication("WLHONEY-SERVER");
        String serviceUrl = EurekaInstanceUtils.getEurekaServiceURI(application, "WLHONEY-SERVER") + "health-check";
        String result = restTemplate.getForObject(serviceUrl, String.class);
        return result;
    }
}
