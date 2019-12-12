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