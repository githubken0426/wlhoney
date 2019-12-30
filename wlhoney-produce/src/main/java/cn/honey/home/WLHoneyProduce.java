package cn.honey.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"cn.honey.home"}, exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
//@EnableDiscoveryClient
public class WLHoneyProduce {

    public static void main(String[] args) {
        SpringApplication.run(WLHoneyProduce.class, args);
    }
}
