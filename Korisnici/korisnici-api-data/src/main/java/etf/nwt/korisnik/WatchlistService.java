package etf.nwt.korisnik;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.Connection;


@Service
public class WatchlistService  {


	@Autowired
	private WatchlistRepository watchlistRepository;
	
//	private  List<Korisnik> korisnici = new ArrayList<>( Arrays.asList(
//			 new Korisnik("Arza","Malkic","arza","arza"),
//			 new Korisnik("Elmaza","Kurtanovic","elmaza","elmaza")
//			 
//			 ));
//	
	public List<Watchlist> getAllWatchlist(){

		List<Watchlist> watchlist = new ArrayList<>();
		watchlistRepository.findAll().forEach(watchlist::add);
		return watchlist;
		
	 }
	

	
	public Watchlist getWatchlist(int id)
	{
		
		//return korisnici.stream().filter(k -> k.getId()==id).findFirst().get();
		return watchlistRepository.findOne(id);
	}
	
	public void addWatchlist(Watchlist watchlist)
	{
		
	
		watchlistRepository.save(watchlist);
	}
	
	

	public void updateWatchlist(Watchlist Watchlist) {
		//long x=id;
		watchlistRepository.save(Watchlist);
	
	}

	
	
	public void deleteKorisnik(int id)
	{
		
		//korisnici.removeIf(k-> k.getId()== id);
		watchlistRepository.delete(id);
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