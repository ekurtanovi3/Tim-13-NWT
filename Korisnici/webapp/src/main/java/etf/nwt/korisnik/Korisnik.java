package etf.nwt.korisnik;

public class Korisnik {

	private int Id; 
	private String Ime;
	private String Prezime;
	private String Username;
	private String Password;
	
	public Korisnik() {}
	
	public Korisnik(int i, String ime, String prezime, String username, String password) {
		super();
		Id = i;
		Ime = ime;
		Prezime = prezime;
		Username = username;
		Password = password;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getIme() {
		return Ime;
	}
	public void setIme(String ime) {
		Ime = ime;
	}
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	
}
