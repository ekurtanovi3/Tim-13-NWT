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


@CrossOrigin
@RestController
public class GlumciController {
	
	@Autowired
	private GlumciService GlumciService;

	@Autowired
	private RestTemplate restTemp;
	
	@RequestMapping("/Glumci")
	public List<Glumci> getAllGlumci()
	{
		return GlumciService.getAllGlumci();
	}
	
	@RequestMapping("/Glumci/{id}")
	public Glumci getGlumci(@PathVariable int id){
		return GlumciService.getGlumci(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Glumci")
	public void addGlumci(@RequestBody Glumci Glumci)
	{
		GlumciService.addGlumci(Glumci);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Glumci")
	public void updateGlumci(@RequestBody Glumci Glumci){
		GlumciService.updateGlumci(Glumci);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Glumci/{id}")
	public void deleteGlumci(@PathVariable int id)
	{
		GlumciService.deleteGlumci(id);
	}
	/*
	@RequestMapping(value="/Glumci/getMoviesById/{id}")
	public String getMoviesById(@PathVariable("id") Integer id)
	{
		String name=restTemp.getForObject("http://filmovi/films/filmoveTest/" +id,String.class);
		return name;
	}*/
	
	@RequestMapping(value="/Glumci/getMoviesById/{id}", produces = "application/json")
	public String getMoviesById(@PathVariable("id") Integer id)
	{
		String name=restTemp.getForObject("http://filmovi/films/filmoveOdGlumca/" +id,String.class);
		
		return name;
	}
	
	@RequestMapping(value="/Glumci/findGlumciByIds/{ids}")
	public List<Glumci> findByIds(@PathVariable List<Long> ids)
	{
		List<Integer> list = new ArrayList<Integer>();
		for(Long i: ids){
		list.add(i.intValue());
		}
		return GlumciService.findByIds(list);
	}
	
	
}
