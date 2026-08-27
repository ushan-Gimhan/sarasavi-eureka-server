package lk.sarasavi.eureka;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.eureka.EurekaServerConfig;
import com.netflix.eureka.cluster.PeerEurekaNodes;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import com.netflix.eureka.resources.ServerCodecs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @Bean
    @Primary
    public PeerEurekaNodes peerEurekaNodes(PeerAwareInstanceRegistry registry,
                                          EurekaServerConfig serverConfig,
                                          EurekaClientConfig clientConfig,
                                          ServerCodecs serverCodecs,
                                          ApplicationInfoManager applicationInfoManager) {
        return new PeerEurekaNodes(registry, serverConfig, clientConfig, serverCodecs, applicationInfoManager) {
            @Override
            protected List<String> resolvePeerUrls() {
                return Arrays.asList(
                    "http://vm-node-a.platform:8761/eureka/",
                    "http://vm-node-b.platform:8761/eureka/",
                    "http://vm-node-c.platform:8761/eureka/"
                );
            }
        };
    }
}
