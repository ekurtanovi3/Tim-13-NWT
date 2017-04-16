package etf.nwt.tim13.actor_movie;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import etf.nwt.tim13.film.FilmEntity;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation;

//import com.netflix.discovery.DiscoveryClient;

import java.util.List;

//import org.springframework.cloud.client.ServiceInstance;

//@RepositoryRestResource
public interface Actor_Movie_Repository extends CrudRepository<Actor_Movie, Integer> {

	@Query ("SELECT am FROM Actor_Movie am WHERE am.actorFK= ?1")
	public List<Actor_Movie> findMoviesByActor(int actorId);

	@Query ("SELECT am.movieFK FROM Actor_Movie am WHERE am.actorFK= ?1")
	public List<Integer> findMoviesIDsByActor(Integer actorId);
	
	
	
	
	
}
