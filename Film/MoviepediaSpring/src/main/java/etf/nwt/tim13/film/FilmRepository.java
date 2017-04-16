package etf.nwt.tim13.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import etf.nwt.tim13.actor_movie.Actor_Movie_Service;

public interface FilmRepository extends CrudRepository<FilmEntity, Integer> {

	
	public List<FilmEntity> findByNameContaining(String word);
	public List<FilmEntity> findByDirectorContaining(String director);
	//@Query ("SELECT am.movieFK FROM Actor_Movie am WHERE am.actorFK= ?1")
	//public List<Integer> findMoviesIDsByActor(Integer actorId);
	
	//@Query ("SELECT fe.* FROM FilmEntity fe")
	//public List<FilmEntity> findFilmoveOdGlumca(Integer actorId);
	//neki komentar
}
