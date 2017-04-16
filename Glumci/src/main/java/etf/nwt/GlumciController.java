package etf.nwt;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("Glumci")
public class GlumciController {
	
	@Autowired
	private GlumciService GlumciService;
	
	@Autowired
	private RestTemplate rt;
	
	@RequestMapping("/getAll")
	public List<Glumci> getAllGlumci()
	{
		return GlumciService.getAllGlumci();
	}
	
	@RequestMapping("/{id}")
	public Glumci getGlumci(@PathVariable int id){
		return GlumciService.getGlumci(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addGlumci(@RequestBody Glumci Glumci)
	{
		GlumciService.addGlumci(Glumci);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public void updateGlumci(@RequestBody Glumci Glumci, @PathVariable int id){
		GlumciService.updateGlumci(id, Glumci);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteGlumci(@PathVariable int id)
	{
		GlumciService.deleteGlumci(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/searchByName/{name}")
	public void searchByName(@PathVariable String name)
	{
		GlumciService.searchByName(name);
	}
	@RequestMapping(method=RequestMethod.GET, value="/searchByLastName/{lastName}")
	public void searchByLastName(@PathVariable String lastName)
	{
		GlumciService.searchByLastName(lastName);
	}
	
	// GET http://localhost:8080/Glumci/test/1,2,3,4 poziv za metodu ispod
	
	@RequestMapping(value="/GetListGlumciById/{firstNameIds}", method=RequestMethod.GET)
	public List<Glumci> getListGlumciById(@PathVariable Integer[] glumciIds) //moze i string primit ako bude problem
	{
		return GlumciService.getListGlumciById(glumciIds);
	}
	// communication with filmovi
	@RequestMapping(method=RequestMethod.GET, value="/getMovies/{id}")
	public void getMoviesById(@PathVariable Integer id)
	{
		List<String> movies = rt.getForObject("http://filmovi/user/logged?id="+id,List.class);
		return movies;
	}
}
