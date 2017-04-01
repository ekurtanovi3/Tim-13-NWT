package etf.nwt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Komentari {
	
	@Id
	@GeneratedValue
	private long idKomentara;
	private String tekstKomentara;
	private long idUsera;
	private long idFilma;
	
	public Komentari() {}

	public Komentari(String tekstKomentara, long idUsera, long idFilma) {
		super();
		this.tekstKomentara = tekstKomentara;
		this.idUsera = idUsera;
		this.idFilma = idFilma;
	}
	
	public Komentari(String tekstKomentara) {
		super();
		this.tekstKomentara = tekstKomentara;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public long getIdKomentara() {
		return idKomentara;
	}

	public void setIdKomentara(long idKomentara) {
		this.idKomentara = idKomentara;
	}

	public String getTekstKomentara() {
		return tekstKomentara;
	}

	public void setTekstKomentara(String tekstKomentara) {
		this.tekstKomentara = tekstKomentara;
	}

	public long getIdUsera() {
		return idUsera;
	}

	public void setIdUsera(long idUsera) {
		this.idUsera = idUsera;
	}

	public long getIdFilma() {
		return idFilma;
	}

	public void setIdFilma(long idFilma) {
		this.idFilma = idFilma;
	}
	

}
