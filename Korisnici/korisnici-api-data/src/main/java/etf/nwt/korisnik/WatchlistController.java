package etf.nwt.korisnik;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class WatchlistController {
	

	@Autowired
	private WatchlistService watchlistService;
	
	@RequestMapping("/Watchlist")
	public List<Watchlist> getAllWatchlist()
	 { return watchlistService.getAllWatchlist();
	 
	 }
	
	@RequestMapping("/Watchlist/{watchlistid}")
	public Watchlist getWatchlist(@PathVariable int watchlistid)
{
		return watchlistService.getWatchlist(watchlistid);

}
	
	@RequestMapping(method=RequestMethod.POST, value="/Watchlist")
	public void AddWatchlist(@RequestBody Watchlist watchlist)
	{
		watchlistService.addWatchlist(watchlist);
}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Watchlist")
	public void updateWatchlist(@RequestBody Watchlist Watchlist){
		watchlistService.updateWatchlist(Watchlist);
	}
	
	@RequestMapping(value="/Watchlist/findByKorisnikid/{korisnikid}")
	public List<Integer> findByKorisnikid(@PathVariable int korisnikid)
	{
		return watchlistService.findByKorisnikid(korisnikid);
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Watchlist/{id}")
	public void DeleteWatchlist(@PathVariable int id)
	{
		watchlistService.deleteKorisnik(id);
}
	
	
}
