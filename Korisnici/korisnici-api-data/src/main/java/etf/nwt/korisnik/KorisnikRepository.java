
package etf.nwt.korisnik;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface KorisnikRepository extends CrudRepository<Korisnik,Integer> {

	//public List<Korisnik> findByIme(@Param("ime")String ime);
	
	@Query("SELECT k FROM Korisnik k WHERE k.ime=?1")
	public List<Korisnik> findByIme(@Param("ime")String ime);
	
	@Query("SELECT k FROM Korisnik k WHERE k.username=?1")
	public List<Korisnik> findByUsername(@Param("username")String username);
	
	@Query( "SELECT k FROM Korisnik k WHERE k.id in :ids" )
	public List<Korisnik> findByIds(@Param("ids") List<Integer> idUserList);
	
	
	



}
