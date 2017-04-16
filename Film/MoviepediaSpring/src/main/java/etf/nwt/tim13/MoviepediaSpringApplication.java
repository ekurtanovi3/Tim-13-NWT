package etf.nwt.tim13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class MoviepediaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviepediaSpringApplication.class, args);
	}
}
