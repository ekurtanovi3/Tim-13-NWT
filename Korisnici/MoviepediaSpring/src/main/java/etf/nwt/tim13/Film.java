package etf.nwt.tim13;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Film {
	
	@Id
	@GeneratedValue
   private BigInteger filmID;
	
	private String Naziv;
	
	public Film () {}
	
	public Film(String Naziv) {
		super();
		this.Naziv = Naziv;
	}
		
		@Override
		public String toString(){
			return ToStringBuilder.reflectionToString(this);
		}

		public BigInteger getFilmID() {
			return filmID;
		}

		public void setFilmID(BigInteger filmID) {
			this.filmID = filmID;
		}

		public String getNaziv() {
			return Naziv;
		}

		public void setNaziv(String Naziv) {
			this.Naziv = Naziv;
		}

	
	}
	
	
	
	




