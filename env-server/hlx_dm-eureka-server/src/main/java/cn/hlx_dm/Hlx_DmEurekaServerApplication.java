package cn.hlx_dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Hlx_DmEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hlx_DmEurekaServerApplication.class, args);
    }
}