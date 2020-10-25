package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;

public class Room {
	
	private int number;
	private Number beds;
	private boolean balcon;
	private BigDecimal price;
	private Wing wing;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Number getBeds() {
		return beds;
	}
	public void setBeds(Number beds) {
		this.beds = beds;
	}
	public boolean isBalcon() {
		return balcon;
	}
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Wing getWing() {
		return wing;
	}
	public void setWing(Wing wing) {
		this.wing = wing;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (balcon ? 1231 : 1237);
		result = prime * result + ((beds == null) ? 0 : beds.hashCode());
		result = prime * result + number;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((wing == null) ? 0 : wing.hashCode());
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
		Room other = (Room) obj;
		if (balcon != other.balcon)
			return false;
		if (beds == null) {
			if (other.beds != null)
				return false;
		} else if (!beds.equals(other.beds))
			return false;
		if (number != other.number)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (wing == null) {
			if (other.wing != null)
				return false;
		} else if (!wing.equals(other.wing))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Room [number=" + number + ", beds=" + beds + ", balcon=" + balcon + ", price=" + price + ", wing="
				+ wing.getDescription() + "]";
	}
	
	
	
}
