
package etf.nwt.korisnik;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
//@Controller

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
	@RequestMapping(value="/g", method=RequestMethod.GET)
	public ModelAndView getKorisnik()
{
		return new ModelAndView("ime.html");
}
	@RequestMapping("/glumac/**")
	public String login( ModelAndView mav){
		
		
		//Korisnik korisnik=korisnikService.getKorisnik(id);
	      return ("ime.html");
	      //mav.addObject("idGlumca", id);
	     // mav.addObject(attributeName, attributeValue)
	      

		//return mav;
		
	}
	
	@RequestMapping(value="/Korisnici/findByUserIds/{ids}")
	public List<Korisnik> findByIds(@PathVariable List<Long> ids)
	{
		List<Integer> list = new ArrayList<Integer>();
		for(Long i: ids){
		list.add(i.intValue());
		}
		return korisnikService.findByIds(list);
	}
	
	
	}
