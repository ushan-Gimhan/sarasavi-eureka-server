package lk.sarasavi.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @Bean
    @Primary
    public EurekaClientConfigBean eurekaClientConfigBean() {
        EurekaClientConfigBean config = new EurekaClientConfigBean();
        Map<String, String> map = new HashMap<>();
        map.put("defaultZone", "http://vm-node-a.platform:8761/eureka/,http://vm-node-b.platform:8761/eureka/,http://vm-node-c.platform:8761/eureka/");
        config.setServiceUrl(map);
        config.setRegisterWithEureka(true);
        config.setFetchRegistry(true);
        return config;
    }
}
