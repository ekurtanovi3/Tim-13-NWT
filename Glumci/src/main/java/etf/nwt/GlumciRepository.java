package etf.nwt;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface GlumciRepository extends CrudRepository<Glumci, Integer> {
	
	@Query ("SELECT g FROM Glumci g  WHERE g.FirstName= ?1")
	public List<Glumci> findByName(String name);
	
	@Query ("SELECT g FROM Glumci g  WHERE g.LastName= ?1")
	public List<Glumci> findByLastName(String lastName);
	
	@Query ("SELECT g FROM Glumci g  WHERE g.GlumacID IN ?1")
	public List<Glumci> getListGlumciById(Integer[] glumciIds)
	
}
