package OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Adhar {
	@Id
	private int id;
	private  String location;
	@OneToOne(mappedBy = "adhar")
	private Person person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Adhar() {
		
	}
	public Adhar(int id, String location) {
		
		this.id = id;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Adhar [id=" + id + ", location=" + location + "]";
	}
}
