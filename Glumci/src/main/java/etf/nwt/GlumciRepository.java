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


public interface GlumciRepository extends CrudRepository<Glumci, Integer> {
	public List<Glumci> findByName(name);
	public List<Glumci> findByLastName(lastName);
	
	
	Connection con=null;
		
			private ResultSet getResultSet(String command) // throws SQLException 
		    {

		        Statement stmt = null;

		        try 
		        {
		            stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery(command);
		            return rs;
		        } 

		        catch (Exception e ) 
		        {
		            e.printStackTrace();
		        } 

		        return null;

		    }
}
