package etf.nwt;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KomentariController {
	
	@Autowired
	private KomentariService KomentariService;

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
}

