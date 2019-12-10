package cn.honey.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"cn.honey.home"}, exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
//@EnableDiscoveryClient
public class WLHoneyClientProduce {

    public static void main(String[] args) {
        SpringApplication.run(WLHoneyClientProduce.class, args);
    }
}
