package etf.nwt.korisnik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class KorisnikService  {

	private  List<Korisnik> korisnici = new ArrayList<>( Arrays.asList(
			 new Korisnik(1,"Arza","Malkic","arza","arza"),
			 new Korisnik(2,"Elmaza","Kurtanovic","elmaza","elmaza")
			 
			 
			 ));
	
	public List<Korisnik> getAllKorisnici(){
	return korisnici; }
	

	
	public Korisnik getKorisnik(int id)
	{
		
		return korisnici.stream().filter(k -> k.getId()==id).findFirst().get();
	}
	
	public void addKorisnik(Korisnik korisnik)
	{
		
		korisnici.add(korisnik);
	}
	
	
	public void updateKorisnik( int id, Korisnik korisnik)
	{
		for(int i=0; i<korisnici.size(); i++)
{
	Korisnik k= korisnici.get(i);
	if(k.getId()==id)
	{
		korisnici.set(i,korisnik);
		return;
	}
}

}
	
	
	public void deleteKorisnik(int id)
	{
		
		korisnici.removeIf(k-> k.getId()== id);
	}
	
}
