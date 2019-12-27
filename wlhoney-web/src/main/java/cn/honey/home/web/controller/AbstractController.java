package cn.honey.home.web.controller;

import cn.honey.home.web.GlobalProperties;
import com.netflix.discovery.EurekaClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public abstract class AbstractController {
    public static final Logger logger = LogManager.getLogger();
    @Qualifier("eurekaClient")
    @Autowired
    public EurekaClient eurekaClient;
    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public GlobalProperties global;
}