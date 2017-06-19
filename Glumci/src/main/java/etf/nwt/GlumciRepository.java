package etf.nwt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface GlumciRepository extends CrudRepository<Glumci, Integer> {
	

	@Query( "SELECT g FROM Glumci g WHERE g.GlumacID in :ids" )
	public List<Glumci> findByIds(@Param("ids") List<Integer> idUserList);
	
}
