package etf.nwt.korisnik;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Watchlist {
	@Id
	@GeneratedValue
	private int id; 
	
	private int korisnikid;
	private int filmid;

	
	public Watchlist() {}
	
	public Watchlist( int korisnikid, int filmid) {
		super();
		
		this.korisnikid = korisnikid;
		this.filmid = filmid;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int watchlistid) {
		this.id = watchlistid;
	}
	public int getKorisnikId() {
		return korisnikid;
	}
	public void setKorisnikId(int korisnikid) {
		this.korisnikid = korisnikid;
	}
	public int getFilmid() {
		return filmid;
	}
	public void setFilmid(int filmid) {
		this.filmid = filmid;
	}
	
}