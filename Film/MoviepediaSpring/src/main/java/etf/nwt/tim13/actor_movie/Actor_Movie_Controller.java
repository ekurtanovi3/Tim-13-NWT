package etf.nwt.tim13.actor_movie;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import etf.nwt.tim13.film.FilmEntity;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
//import com.netflix.discovery.DiscoveryClient;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;


@RestController
public class Actor_Movie_Controller {
	
	@Autowired
	private Actor_Movie_Service amService;
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	@RequestMapping("/actor_movie")
	public List<Actor_Movie> getAllactor_movie()
	{
		return amService.getAllactor_movie();
	}
	
	@RequestMapping("/actor_movie/{id}")
	public Actor_Movie getActor_Movie(@PathVariable int id){
		return amService.getActor_Movie(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/actor_movie")
	public void addFilm(@RequestBody Actor_Movie am)
	{
		amService.addActor_Movie(am);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/actor_movie")
	public void updateFilm(@RequestBody Actor_Movie am){
		amService.updateActor_Movie(am);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/actor_movie/{id}")
	public void deleteFilm(@PathVariable int id)
	{
		amService.deleteActor_Movie(id);
	}
	
	@RequestMapping("/actor_movie/filmoviOdGlumca/{id}")
	public List<Actor_Movie> getFilmoviOdGlumca(@PathVariable int id)  {
			return amService.findMoviesByActor(id);
		
		}
	@RequestMapping("/actor_movie/idfilmovaOdGlumca/{id}")
	public List<Integer> findMoviesIDsByActor(@PathVariable Integer id) {
		return amService.findMoviesIDsByActor(id);
	}
	
	

		

}
