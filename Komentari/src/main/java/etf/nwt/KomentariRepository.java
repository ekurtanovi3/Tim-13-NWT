package etf.nwt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KomentariRepository extends JpaRepository<Komentari, Long>{
	
	@Query("SELECT k FROM Komentari k WHERE k.idFilma=?1")
	public List<Komentari> getForMovie(@Param("id") long id);
	
	@Query("SELECT k FROM Komentari k WHERE k.idUsera=?1")
	public List<Komentari> getForUser(@Param("id") long id);

}