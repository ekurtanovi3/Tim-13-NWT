package etf.nwt;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KomentariService {
	
	@Autowired
	private KomentariRepository KomentariRepository;
	private List<Komentari> Komentari= new ArrayList<>(Arrays.asList(
			
			new Komentari("Komentari1"),
			new Komentari("Komentari2"),
			new Komentari("Komentari3")
			));
	
	public List<Komentari> getAllKomentari(){
		
		
		List<Komentari> Komentari = new ArrayList<>();
		 KomentariRepository.findAll().forEach(Komentari::add);
		 return Komentari;
	}
	
	public Komentari getKomentari(long id){
	
		return KomentariRepository.findOne(id);
	}

	public void addKomentari(Komentari Komentari) {
		KomentariRepository.save(Komentari);		
	}


	public void deleteKomentari 	(long id) {
		KomentariRepository.delete(id);
	}

	public void updateKomentari(long id, Komentari Komentari) {
		//long x=id;
		KomentariRepository.save(Komentari);
		
	}
	
	public List<Komentari> getForMovie(long id) {
		List<Komentari> Komentari = new ArrayList<>();
		KomentariRepository.getForMovie(id).forEach(Komentari::add);
		return Komentari;
	}
	
	public List<Komentari> getForUser(long id) {
		List<Komentari> Komentari = new ArrayList<>();
		KomentariRepository.getForUser(id).forEach(Komentari::add);
		return Komentari;
	}
	
	
}