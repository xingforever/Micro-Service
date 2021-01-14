package cn.hlx_dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class HlxDmUserProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlxDmUserProviderApplication.class, args);
	}

}
