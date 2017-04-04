package etf.nwt.tim13.film;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<FilmEntity, Integer> {

	
	public List<FilmEntity> findByNameContaining(String word);
	public List<FilmEntity> findByDirectorContaining(String director);
}
