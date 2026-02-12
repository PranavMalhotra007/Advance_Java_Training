package OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CinemaHall {
	@Id
	private int id;
	private int noOfSeats;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public CinemaHall() {
	
	}
	public CinemaHall(int id, int noOfSeats) {
		
		this.id = id;
		this.noOfSeats = noOfSeats;
	}
}
