package etf.nwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KomentariApplication implements CommandLineRunner {

	@Autowired
	KomentariRepository komentariRepository;
	public static void main(String[] args) {
		SpringApplication.run(KomentariApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Komentari[] komentariArray= {
			new Komentari("komentar1TekstKomentara"),
			new Komentari("komentar2TekstKomentara"),
			new Komentari("komentar1TekstKomentara")
		};
		
		for (Komentari komentari : komentariArray) {
			komentariRepository.save(komentari);
		}
			
		List<Komentari> listaKomentara = komentariRepository.findAll();
		
		for (Komentari komentari : listaKomentara) {
			System.out.println("Komentar" + komentari.toString());
		}
	}
}
