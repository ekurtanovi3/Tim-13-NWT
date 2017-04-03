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
public class GlumciController {
	
	@Autowired
	private GlumciService GlumciService;

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
	
	@RequestMapping(method=RequestMethod.PUT, value="/Glumci/{id}")
	public void updateGlumci(@RequestBody Glumci Glumci, @PathVariable int id){
		GlumciService.updateGlumci(id, Glumci);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Glumci/{id}")
	public void deleteGlumci(@PathVariable int id)
	{
		GlumciService.deleteGlumci(id);
	}
}
