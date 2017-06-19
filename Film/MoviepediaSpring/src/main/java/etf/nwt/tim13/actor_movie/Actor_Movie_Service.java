package etf.nwt.tim13.actor_movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.fabric.Response;

import etf.nwt.tim13.film.FilmEntity;

/*import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;*/
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Service
public class Actor_Movie_Service {
	
	@Autowired
	private Actor_Movie_Repository amRepository;
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
public List<Actor_Movie> getAllactor_movie(){
		
		List<Actor_Movie> actor_movie_list = new ArrayList<>();
		amRepository.findAll().forEach(actor_movie_list::add);
		return actor_movie_list;
	}
	
	public Actor_Movie getActor_Movie(int id){
	//return 	films.stream().filter(f -> f.getId()==id).findFirst().get();
		return amRepository.findOne(id);
	}

	public void addActor_Movie(Actor_Movie am) {
		amRepository.save(am);		
	}


	public void deleteActor_Movie 	(int id) {
		amRepository.delete(id);
	}

	public void updateActor_Movie(Actor_Movie am) {
		//int x=id;
		amRepository.save(am);
		
		
	}
	
	public List<Actor_Movie> findMoviesByActor(int id) {
		List<Actor_Movie> filmovi= new ArrayList<Actor_Movie>();
		amRepository.findMoviesByActor(id).forEach(filmovi::add);
		return filmovi;
	}
	

	public List<Integer> findMoviesIDsByActor(Integer actorId) {
		return amRepository.findMoviesIDsByActor(actorId);
		
	}
	public List<Integer> findActorFKByMovieFK( Integer id) {
		return amRepository.findActorFKByMovieFK(id);
	}
	
	
	
}
	
	/*public Response getEurekaDetails() {
	   // List<EurekaInstanceInfo> instanceInfoList = new ArrayList<EurekaInstanceInfo>();

	    DiscoveryClient discoveryClient = DiscoveryManager.getInstance()
	            .getDiscoveryClient();
	    List<ServiceInstance> servisF = new ArrayList<>();
	 
	   discoveryClient.
	            
	   
	    if (null != discoveryClient) {
	        Applications apps = discoveryClient.getApplications();
	        for (Application app : apps.getRegisteredApplications()) {
	            for (InstanceInfo inst : app.) {
	                if(inst.getAppName()=="filmovi")
	                {
	                	servisF.add(inst);
	                }
	                
	            
	            }
	        }
	    }

	}*/
	/*public List<ServiceInstance> findMoviesByActor(int id){
		
	/	List<ServiceInstance> instances = new ArrayList<>();
		discoveryClient = DiscoveryManager.getInstance().getDiscoveryClient();
		
		if (null != discoveryClient) {
	        Applications apps = discoveryClient.getApplications();
	        for (Application app : apps.getRegisteredApplications()) {
	            for (String s : app.getName()) {
	               if (inst.getAppName()=="filmovi")
	               inst.getId(), inst.getStatus()
	                        .name(), inst.getIPAddr(), inst.getHostName()));
	            }
	        }
	    }/
	
		List<ServiceInstance> instances=discoveryClient.getInstances("filmovi");
		ServiceInstance serviceInstance=instances.get(0);
		amRepository.findMoviesByActor(id).forEach(instances::add);
		return instances;*/
	

	
/*	@RequestMapping("/komentariKorisnici/{id}")
	public ResponseEntity<String> getKorisnici(@PathVariable long id) throws RestClientException, IOException {
			
		Komentari k=KomentariService.getKomentari(id);
		id=k.getIdUsera();
			List<ServiceInstance> instances=discoveryClient.getInstances("filmovi");
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

	*/
	

