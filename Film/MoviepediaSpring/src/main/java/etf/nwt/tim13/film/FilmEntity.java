package etf.nwt.tim13.film;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FilmEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private String director;
	private int duration;
	
	
	public FilmEntity() {}
	
	
	public FilmEntity(String name, String description, String director, int duration) {
		super();
	
		this.name = name;
		this.description = description;
		this.director = director;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

}
