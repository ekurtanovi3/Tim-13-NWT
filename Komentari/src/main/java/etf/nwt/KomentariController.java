package etf.nwt;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class KomentariController {
	
	@Autowired
	private KomentariService KomentariService;
	

	/*@Autowired
	private RestTemplate restTemp;*/

	@RequestMapping("/komentari")
	public List<Komentari> getAllKomentari()
	{
		return KomentariService.getAllKomentari();
	}
	
	@RequestMapping("/komentari/{id}")
	public Komentari getKomentari(@PathVariable long id){
		return KomentariService.getKomentari(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/komentari")
	public void addKomentari(@RequestBody Komentari Komentari)
	{
		KomentariService.addKomentari(Komentari);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/komentari/{id}")
	public void updateKomentari(@RequestBody Komentari Komentari, @PathVariable long id){
		KomentariService.updateKomentari(id, Komentari);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/komentari/{id}")
	public void deleteKomentari(@PathVariable long id)
	{
		KomentariService.deleteKomentari(id);
	}
	
	@RequestMapping("/komentariPoFilmu/{id}")
	public List<Komentari> getForMovie(@PathVariable long id)
	{
		return KomentariService.getForMovie(id);
	}
	
	@RequestMapping("/komentariPoUseru/{id}")
	public List<Komentari> getForUser(@PathVariable long id)
	{
		return KomentariService.getForUser(id);
	}
	
	@RequestMapping(value="/komentariPoFilmuWithUserIds/{id}", produces = "application/json")
	public String getForMovieWithUserIds(@PathVariable long id)
	{
		List<Komentari> kom=KomentariService.getForMovie(id);
		List<Long> idUsera=new ArrayList<>();
        for(int i=0;i<kom.size();i++)
	    idUsera.add(kom.get(i).getIdUsera());
       // RestTemplate restTemplate = new RestTemplate();

		//String name=restTemp.getForObject("http://korisnici/findByUserIds/1",String.class);
        //return name;
		return (idUsera.toString());
        //return idUsera;
	}
}
