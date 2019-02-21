package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bands")
public class Band {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bandid")
	private int bandId;
	@Column(name="bandname")
	private String bandName;
	@Column(name="numMembers")
	private int numMembers;
	@Column(name="style")
	private String musicStyle;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Musician> bandMembers;
	
	public Band() {
		super();
	}
	
	public Band(String bandName) {
		super();
		this.bandName = bandName;
	}
	
	public Band(String bandName, String musicStyle) {
		super();
		this.bandName = bandName;
		this.musicStyle = musicStyle;
	}

	public Band(String bandName, int numMembers, String musicStyle) {
		super();
		this.bandName = bandName;
		this.numMembers = numMembers;
		this.musicStyle = musicStyle;
	}

	public Band(int id, String bandName, int numMembers, String musicStyle) {
		super();
		this.bandId = id;
		this.bandName = bandName;
		this.numMembers = numMembers;
		this.musicStyle = musicStyle;
	}

	
	
	public int getBandId() {
		return bandId;
	}

	public String getBandName() {
		return bandName;
	}


	public void setBandName(String bandName) {
		this.bandName = bandName;
	}


	public int getNumMembers() {
		return numMembers;
	}


	public void setNumMembers(int numMembers) {
		this.numMembers = numMembers;
	}


	public String getMusicStyle() {
		return musicStyle;
	}


	public void setMusicStyle(String musicStyle) {
		this.musicStyle = musicStyle;
	}
	
	public void setBandMembers(List<Musician> bandMembers) {
		this.bandMembers = bandMembers;
		
	}
	
	public List <Musician>getBandMembers() {
		return this.bandMembers;
	}
	
	public String bandDetails() {
		return "Band name: " + bandName  + "\nStyle: " + musicStyle +  "\nNumber of members: " + numMembers + "\n";
	}
	
	
}
