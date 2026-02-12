package com.lpu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Adhaar {
@Id
private int id;
private String Location;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLocation() {
	return Location;
}

public void setLocation(String location) {
	Location = location;
}

public Adhaar(int id, String location) {
	super();
	this.id = id;
	Location = location;
}

public Adhaar() {
	
}

}
