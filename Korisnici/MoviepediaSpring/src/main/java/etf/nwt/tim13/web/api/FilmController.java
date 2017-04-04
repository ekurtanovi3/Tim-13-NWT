package etf.nwt.tim13.web.api;


import java.util.Collection;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import etf.nwt.tim13.Film;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilmController {
	
	

	
	
	
	
	//kkkkkkkkkkkkk

	private static BigInteger nextId;
    private static Map<BigInteger, Film> filmMap;
    
    private static Film save(Film film) {
        if (filmMap == null) {
        	filmMap = new HashMap<BigInteger, Film>();
            nextId = BigInteger.ONE;
            
            // If Update...
            if (film.getFilmID() != null) {
            	Film oldFilm = filmMap.get(film.getFilmID());
                if (oldFilm == null) {
                    return null;
                }
                filmMap.remove(film.getFilmID());
                filmMap.put(film.getFilmID(), film);
                return film;
            }
            // If Create...
            film.setFilmID(nextId);
            nextId = nextId.add(BigInteger.ONE);
            return film;
        }
            
        
        film.setFilmID(nextId);
        nextId = nextId.add(BigInteger.ONE);
        filmMap.put(film.getFilmID(), film);
        return film;
    }


    
    private static boolean delete(BigInteger id) {
        Film deletedFilm= filmMap.remove(id);
        if (deletedFilm == null) {
            return false;
        }
        return true;
    }

    static {
        Film g1 = new Film();
        g1.setNaziv("Hello World!");
        ;
        save(g1);

        Film g2 = new Film();
        g2.setNaziv("Hola Mundo!");
        save(g2);
    }

    
    
	
	@RequestMapping(value="/api/filmovi",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Film>> getfilmovi()
     {
		 Collection<Film> filmovi = filmMap.values();

	        return new ResponseEntity<Collection<Film>>(filmovi,
	                HttpStatus.OK);
		
     }
	
	   @RequestMapping(
	            value = "/api/filmovi/{id}",
	            method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Film> getFilm(
	            @PathVariable("id") BigInteger id) {

	        Film film = filmMap.get(id);
	        if (film == null) {
	            return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<Film>(film, HttpStatus.OK);
	    }

	   
	   @RequestMapping(
	            value = "/api/filmovi",
	            method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Film> createGreeting(
	            @RequestBody Film film) {

		   Film savedFilm = save(film);

	        return new ResponseEntity<Film>(savedFilm, HttpStatus.CREATED);
	    }
	   
	   
	   @RequestMapping(
	            value = "/api/filmovi/{id}",
	            method = RequestMethod.PUT,
	            consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Film> updateFilm(
	            @RequestBody Film film) {

	        Film updatedFilm = save(film);
	        if (updatedFilm== null) {
	            return new ResponseEntity<Film>(
	                    HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        return new ResponseEntity<Film>(updatedFilm, HttpStatus.OK);
	        
	        
	    }
	   
	   @RequestMapping(
	            value = "/api/filmovi/{id}",
	            method = RequestMethod.DELETE,
	            consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Film> deleteFilm(
	            @PathVariable("id") BigInteger id, @RequestBody Film film) {

	        boolean deleted = delete(id);
	        if (!deleted) {
	            return new ResponseEntity<Film>(
	                    HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        return new ResponseEntity<Film>(HttpStatus.NO_CONTENT);

}
	   
}
