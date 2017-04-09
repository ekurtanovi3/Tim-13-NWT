package etf.nwt.korisnik;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface KorisnikRepository extends CrudRepository<Korisnik,Integer> {

	public List<Korisnik> findByIme(@Param("ime")String ime);
	
}