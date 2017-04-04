package etf.nwt.korisnik;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Korisnik {
	@Id
	@GeneratedValue
	private int id; 
	private String ime;
	private String prezime;
	private String username;
	private String password;
	
	public Korisnik() {}
	
	public Korisnik( String ime, String prezime, String username, String password) {
		super();
		
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
