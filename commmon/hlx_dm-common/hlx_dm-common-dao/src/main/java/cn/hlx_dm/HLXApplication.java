package cn.hlx_dm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.hlx_dm.mapper")
public class HLXApplication {

    public static void main(String[] args) {SpringApplication.run(HLXApplication.class, args);

    }

}
