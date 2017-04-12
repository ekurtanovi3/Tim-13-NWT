package etf.nwt;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GlumciService {
	
	@Autowired
	private GlumciRepository GlumciRepository;
	

	Image wall = null;
	
	
	private List<Glumci> glumci= new ArrayList<>(Arrays.asList(
			
			new Glumci("firstName",  "lastName", new Date(), "biografy", wall ),
			new Glumci("firstName",  "lastName", new Date(), "biografy", wall )
			));
	
	public List<Glumci> getAllGlumci(){
		
		//return glumci;
		List<Glumci> glumci = new ArrayList<>();
		 GlumciRepository.findAll().forEach(glumci::add);
		 return glumci;
	}
	
	public Glumci getGlumci(int id){
	//return 	glumci.stream().filter(f -> f.getId()==id).findFirst().get();
		return GlumciRepository.findOne(id);
	}

	public void addGlumac(Glumci glumac) {
		GlumciRepository.save(glumac);		
	}


	public void deleteGlumci(int id) {
		GlumciRepository.delete(id);
	}

	public void updateGlumci(int id, Glumci glumci) {
		int x=id;
		GlumciRepository.save(glumci);
		
	}
	
	public List<Glumci> searchByName(name){
		//return glumci;
		List<Glumci> glumci = new ArrayList<>();
		 GlumciRepository.findByName(name).forEach(glumci::add);
		 return glumci;
	}
	public List<Glumci> searchByLastName(lastName){
		
		//return glumci;
		List<Glumci> glumci = new ArrayList<>();
		GlumciRepository.findByLastName(lastName).forEach(glumci::add);
		return glumci;
	}
	
}
