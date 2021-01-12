package cn.hlx_dm.sleuthserver;

import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class HlxDmSleuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlxDmSleuthServerApplication.class, args);
    }
}