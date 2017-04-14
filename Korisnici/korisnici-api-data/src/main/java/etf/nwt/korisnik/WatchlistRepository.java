package etf.nwt.korisnik;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WatchlistRepository extends CrudRepository<Watchlist,Integer> {

	@Query("SELECT k.filmid FROM Watchlist k WHERE k.korisnikid=?1")
	public List<Integer> findByKorisnikid(@Param("korisnikid")int korisnikid);
	
	
}
