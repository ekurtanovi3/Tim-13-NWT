package etf.nwt.tim13.film;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

//import com.netflix.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
@CrossOrigin
@RestController
//@RequestMapping("/films")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	//@Autowired
	//private DiscoveryClient discoveryClient;

	@RequestMapping("/films")
	public List<FilmEntity> getAllFilms()
	{
		return filmService.getAllFilms();
	}
	
	@RequestMapping("/films/{id}")
	public FilmEntity getFilm(@PathVariable int id){
		return filmService.getFilm(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/films")
	public void addFilm(@RequestBody FilmEntity film)
	{
		filmService.addFilm(film);		
	}
	
	/*@RequestMapping(method=RequestMethod.PUT, value="/films/{id}")
	public void updateFilm(@RequestBody FilmEntity film, @PathVariable int id){
		filmService.updateFilm(id, film);
	}*/
	
	@RequestMapping(method=RequestMethod.PUT, value="/films")
	public void updateFilm(@RequestBody FilmEntity film){
		filmService.updateFilm(film);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/films/{id}")
	public void deleteFilm(@PathVariable int id)
	{
		filmService.deleteFilm(id);
	}
	
	@RequestMapping(value="/films/searchByName/{word}")
	public List<FilmEntity> searchByName(@PathVariable String word)
	{
		return filmService.searchByWord(word);
	}
	
	@RequestMapping(value="/films/searchByDirector/{word}")
	public List<FilmEntity> searchByDirector(@PathVariable String word)
	{
		return filmService.searchByDirector(word);
	}
	
	@RequestMapping(value="/films/idfilmovaOdGlumca/{id}")
	public List<Integer> findMoviesIDsByActor(@PathVariable Integer id) {
		return filmService.findMoviesIDsByActor(id);
	}
	
	@RequestMapping(value="/films/filmoveOdGlumca/{id}")
	public List<FilmEntity> findFilmoveOdGlumca(@PathVariable Integer id)
	 {
		return filmService.findFilmoveOdGlumca(id);
	}
	@RequestMapping(value="/films/filmoveTest/{id}")
	public String filmoveTest(@PathVariable Integer id)
	 {
		return filmService.getFilm(id).getName();
	}
	
	/*@RequestMapping("/filmoviOdGlumca/{id}")
	public ResponseEntity<String> getFilmoveOdGlumca(@PathVariable long id) throws RestClientException, IOException {
			
		List<FilmEntity> filmovi =KomentariService.getKomentari(id);
		id=k.getIdUsera();
			List<ServiceInstance> instances=discoveryClient.getInstances("korisnici");
			ServiceInstance serviceInstance=instances.get(0);
			
			String baseUrl=serviceInstance.getUri().toString();
			
			baseUrl=baseUrl+"/Korisnici/"+id;
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response=null;
			try{
			response=restTemplate.exchange(baseUrl,
					HttpMethod.GET, getHeaders(),String.class);
			}catch (Exception ex)
			{
				System.out.println(ex);
			}
			return response;

			//System.out.println(response.getBody());
		}

		private static HttpEntity<?> getHeaders() throws IOException {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			return new HttpEntity<>(headers);
		} */
	
/*	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@RequestMapping("/names")
	public Collection<String> getReservationNames()
	{
		ParameterizedTypeReference<Resources<Reservation>> ptr =
				new ParameterizedTypeReference<Resources<Reservation>>(){};
		
		ResponseEntity<Resources<Reservation>> responseEntity = 
				this.restTemplate.exchange("http://films/actor_movie", org.springframework.http.HttpMethod.GET, null, ptr);
				return responseEntity
						.getBody()
						.getContent()
						.stream()
						.map(Reservation::getReservationName)
						.collect(Collectors.toList());
	}
	class Reservation {
		
		private Long id;
		private String reservationName;
		public Long getId() {
			return id;
		}
		public String getReservationName() {
			return reservationName;
		}	
		
	}*/
}
