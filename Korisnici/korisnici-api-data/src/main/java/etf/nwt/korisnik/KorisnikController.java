package etf.nwt.korisnik;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping("/Korisnici")
	public List<Korisnik> getAllKorisnici()
	 { return korisnikService.getAllKorisnici();
	 
	 }
	

	
	@RequestMapping("/Korisnici/{id}")
	public Korisnik getKorisnik(@PathVariable int id)
{
		return korisnikService.getKorisnik(id);

}
	
	@RequestMapping(method=RequestMethod.POST, value="/Korisnici")
	public void AddKorisnik(@RequestBody Korisnik korisnik)
	{
		korisnikService.addKorisnik(korisnik);
}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Korisnici/{id}")
	public void updateKorisnik(@RequestBody Korisnik korisnik, @PathVariable int id)
	{
		korisnikService.updateKorisnik(id,korisnik);
}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Korisnici/{id}")
	public void DeleteKorisnik(@PathVariable int id)
	{
		korisnikService.deleteKorisnik(id);
}
	
	

	@RequestMapping(value="/Korisnici/findByIme/{ime}")
	public List<Korisnik> findByIme(@PathVariable String ime)
	{
		return korisnikService.findByIme(ime);
	}
	
	

	@RequestMapping(value="/Korisnici/findByUsername/{username}")
	public List<Korisnik> findByUsername(@PathVariable String username)
	{
		return korisnikService.findByUsername(username);
	}
	
	
	
	}
