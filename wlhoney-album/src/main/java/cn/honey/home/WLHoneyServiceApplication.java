package cn.honey.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WLHoneyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WLHoneyServiceApplication.class, args);
    }

}