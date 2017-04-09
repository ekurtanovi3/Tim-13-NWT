package etf.nwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KorisniciApiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(KorisniciApiDataApplication.class, args);
	}
}
