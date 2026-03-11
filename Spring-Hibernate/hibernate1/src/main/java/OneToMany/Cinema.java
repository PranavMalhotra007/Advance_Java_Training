package OneToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Cinema {
	@Id
	private int id;
	private String name;
	private String Location;
	@OneToMany
	private List<CinemaHall>cinemaHalls ;
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
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public List<CinemaHall> getCinemaHalls() {
		return cinemaHalls;
	}
	public void setCinemaHalls(List<CinemaHall> cinemaHalls) {
		this.cinemaHalls = cinemaHalls;
	}
	public Cinema() {
		
	}
	public Cinema(int id, String name, String location) {
		this.id = id;
		this.name = name;
		Location = location;
	}
}
