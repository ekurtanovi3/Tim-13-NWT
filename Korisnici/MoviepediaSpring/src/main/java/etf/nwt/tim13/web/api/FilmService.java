package etf.nwt.tim13.web.api;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.nwt.tim13.Film;
import etf.nwt.tim13.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	private List<Film> films = new ArrayList<>(Arrays.asList(
			new Film("Naziv1"),
			new Film("Naziv2")
			
			
			
			));
	
	
	public List<Film> getAllFilms()
	{
		List<Film> films= new ArrayList<>();
		filmRepository.findAll()
		.forEach(films::add);
		
		return films;
	}
	
	public Film GetFilm(Long Id)
	{return filmRepository.findOne(Id); }
	
	public void addFilm(Film film)
	{
		filmRepository.save(film);
		
	}
	
}
