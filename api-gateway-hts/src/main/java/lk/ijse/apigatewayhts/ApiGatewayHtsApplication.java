package lk.ijse.apigatewayhts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayHtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayHtsApplication.class, args);
    }

}
