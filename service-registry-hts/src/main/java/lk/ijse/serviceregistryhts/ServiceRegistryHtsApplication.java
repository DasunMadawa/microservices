package lk.ijse.serviceregistryhts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryHtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryHtsApplication.class, args);
    }

}
