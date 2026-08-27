package lk.sarasavi.eureka;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    @Autowired(required = false)
    private EurekaClientConfigBean eurekaClientConfigBean;

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @PostConstruct
    public void init() {
        if (eurekaClientConfigBean != null) {
            Map<String, String> map = new HashMap<>();
            map.put("defaultZone", "http://vm-node-a.platform:8761/eureka/,http://vm-node-b.platform:8761/eureka/,http://vm-node-c.platform:8761/eureka/");
            eurekaClientConfigBean.setServiceUrl(map);
        }
    }
}
