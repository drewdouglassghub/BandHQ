package model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="musicians")
public class Musician {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MUSICIANID")
	private int id;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="INSTRUMENT")
	private String instrument;
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "BANDNAME", referencedColumnName = "BANDNAME") })
	private Band band;

	public Musician() {
		super();
	}	


	public Musician(String first, String last, String instrument) {
		super();

		this.firstName = first;
		this.lastName = last;
		this.instrument = instrument;
	}

	public Musician(String firstName, String lastName, String instrument, Band band) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;
		this.band = band;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}	
	
	public Band getBand() {
		return band;
	}
	
	public void setBand(Band band) {
		this.band = band;
	}
	
	public String toString() {
		return firstName + " " + lastName + " plays " + instrument + " in " + band.getBandName() + "\n";
	}



}
