
package etf.nwt.korisnik;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mysql.jdbc.Connection;


@Service
public class KorisnikService  {


	@Autowired
	private KorisnikRepository korisnikRepository;
	
//	private  List<Korisnik> korisnici = new ArrayList<>( Arrays.asList(
//			 new Korisnik("Arza","Malkic","arza","arza"),
//			 new Korisnik("Elmaza","Kurtanovic","elmaza","elmaza")
//			 
//			 
//			 ));
//	
	public List<Korisnik> getAllKorisnici(){

		List<Korisnik> korisnici = new ArrayList<>();
		korisnikRepository.findAll().forEach(korisnici::add);
		return korisnici;
		
	 }
	

	
	public Korisnik getKorisnik(int id)
	{
		
		//return korisnici.stream().filter(k -> k.getId()==id).findFirst().get();
		return korisnikRepository.findOne(id);
	}
	
	public void addKorisnik(Korisnik korisnik)
	{
		
		//korisnici.add(korisnik);
		korisnikRepository.save(korisnik);
	}
	
	
	public void updateKorisnik(int id, Korisnik korisnik)
	{
		/*for(int i=0; i<korisnici.size(); i++)
{
	Korisnik k= korisnici.get(i);
	if(k.getId()==id)
	{
		korisnici.set(i,korisnik);
		return;
	}
}*/
		korisnikRepository.save(korisnik);

}
	
	
	public void deleteKorisnik(int id)
	{
		
		//korisnici.removeIf(k-> k.getId()== id);
		korisnikRepository.delete(id);
	}
	
	
	public List<Korisnik> findByIme(String ime) {
		List<Korisnik> korisnici = new ArrayList<>();
		korisnikRepository.findByIme(ime).forEach(korisnici::add);
		return korisnici;
	}

	public List<Korisnik> findByUsername(String username) {
		List<Korisnik> korisnici = new ArrayList<>();
		korisnikRepository.findByUsername(username).forEach(korisnici::add);
		return korisnici;
	}


	

	//  public List<Korisnik> findAll() {
	//	  List<Korisnik> korisnici = new ArrayList<>();
	//		korisnikRepository.findAll(sortByIdAsc()).forEach(korisnici::add);
		//	return korisnici(sortByIdAsc());
	      
	   // }

	public List<Korisnik> findByIds(@PathVariable List<Integer> ids)
    {	
		List<Korisnik> korisnici = new ArrayList<>();
	    korisnici=korisnikRepository.findByIds(ids);
	    return korisnici;

		}

	
	 private Sort sortByIdAsc() {
	        return new Sort(Sort.Direction.ASC, "id");
	    }
	
	
	// new services za sve 
	
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
