package etf.nwt.tim13.film;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	private List<FilmEntity> films= new ArrayList<>(Arrays.asList(
			
			new FilmEntity("film1", "description1", "director1", 11),
			new FilmEntity("film2", "description2", "director2", 22),
			new FilmEntity("film3", "description3", "director3", 33)
			));
	
	public List<FilmEntity> getAllFilms(){
		
		List<FilmEntity> films = new ArrayList<>();
		filmRepository.findAll().forEach(films::add);
		return films;
	}
	
	public FilmEntity getFilm(int id){
	//return 	films.stream().filter(f -> f.getId()==id).findFirst().get();
		return filmRepository.findOne(id);
	}

	public void addFilm(FilmEntity film) {
		filmRepository.save(film);		
	}


	public void deleteFilm 	(int id) {
		filmRepository.delete(id);
	}

	public void updateFilm(FilmEntity film) {
		//int x=id;
		filmRepository.save(film);
		
		
	}
	
	public List<FilmEntity> searchByWord(String word)
	{
		List<FilmEntity> films= new ArrayList<>();
		filmRepository.findByNameContaining(word).forEach(films::add);
		return films;
	}
	
	public List<FilmEntity> searchByDirector(String director)
	{
		List<FilmEntity> films= new ArrayList<>();
		filmRepository.findByDirectorContaining(director).forEach(films::add);
		return films;
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
