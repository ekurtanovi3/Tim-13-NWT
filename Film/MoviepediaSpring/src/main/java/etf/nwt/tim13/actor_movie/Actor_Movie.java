package etf.nwt.tim13.actor_movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Actor_Movie {
	
	@Id
	@GeneratedValue
	private int id;
	private int actorFK;
	private int movieFK;

	
	public Actor_Movie() {}
	public Actor_Movie(int actorFK, int movieFK)
	{
		super();
		this.actorFK=actorFK;
		this.movieFK=movieFK;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActorFK() {
		return actorFK;
	}
	public void setActorFK(int actorFK) {
		this.actorFK = actorFK;
	}
	public int getMovieFK() {
		return movieFK;
	}
	public void setMovieFK(int movieFK) {
		this.movieFK = movieFK;
	}
	
}
