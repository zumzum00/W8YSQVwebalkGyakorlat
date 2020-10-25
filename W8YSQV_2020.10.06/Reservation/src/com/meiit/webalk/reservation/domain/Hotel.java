package com.meiit.webalk.reservation.domain;

import java.util.ArrayList;

public class Hotel {

	private String name;
	private String adress;
	private int stars;
	private ArrayList<Floor>floors;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public ArrayList<Floor> getFloors() {
		return floors;
	}
	public void setFloors(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((floors == null) ? 0 : floors.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stars;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (floors == null) {
			if (other.floors != null)
				return false;
		} else if (!floors.equals(other.floors))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stars != other.stars)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", adress=" + adress + ", stars=" + stars + ", floors=" + floors.size() + "]";
	}
	
	
}
