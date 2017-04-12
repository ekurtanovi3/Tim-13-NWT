package etf.nwt;

import java.awt.Image;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class GlumciApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlumciApplication.class, args);
	}
	
	@Autowired
	private GlumciService GlumciService;
	Image wall = null;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		List<Glumci> glumci= new ArrayList<>(Arrays.asList(
			
			new Glumci("firstName",  "lastName", new Date(), "biografy", wall ),
			new Glumci("firstName",  "lastName", new Date(), "biografy", wall )
			));
		
		for (Glumci glumac : glumci) {
			GlumciService.addGlumac(glumac);
		}
			
		List<Glumci> listaGlumaca = GlumciService.getAllGlumci();
		
		for (Glumci glumac : listaGlumaca) {
			System.out.println("Glumac" + glumac.toString());
		}
	}
}
