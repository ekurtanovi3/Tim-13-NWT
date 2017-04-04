package etf.nwt.tim13;

import etf.nwt.tim13.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface FilmRepository extends JpaRepository<Film, Long> {

//}

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

}