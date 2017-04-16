package etf.nwt;

import java.awt.Image;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Glumci {
	
	@Id
	@GeneratedValue
	private Integer GlumacID;
	
	private String FirstName;
	
	private String LastName;
	
	private Date DateOfBirth;
	
	private String Biografy;
	
	private Image Image;
	
	public Glumci(){}


	public Glumci(String firstName, String lastName, Date dateOfBirth, String biografy, java.awt.Image image) {
		super();
		FirstName = firstName;
		LastName = lastName;
		DateOfBirth = dateOfBirth;
		Biografy = biografy;
		Image = image;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public int getGlumacID() {
		return GlumacID;
	}


	public void setGlumacID(int GlumacID) {
		this.GlumacID = GlumacID;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		this.LastName = lastName;
	}


	public Date getDateOfBirth() {
		return DateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.DateOfBirth = dateOfBirth;
	}


	public String getBiografy() {
		return Biografy;
	}


	public void setBiografy(String biografy) {
		this.Biografy = biografy;
	}


	public Image getImage() {
		return Image;
	}


	public void setImage(Image image) {
		this.Image = image;
	}



	
	

}
