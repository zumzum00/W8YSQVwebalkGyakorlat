package com.meiit.webalk.reservation.view;

import java.util.ArrayList;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;

//List<>, NAMEING
public interface View {

	public BookingPerson readBookingPerson();
	
	public void printWelcomeMessage(BookingPerson p);
	
	public void printBalance(BookingPerson p);
	
	public void printRooms(ArrayList<Hotel> l);
	
	public Room selectRoom(ArrayList<Hotel> l);	
	
	public void printReservationSaved(Reservation r);	
	
	public void printNotEnoughBalance(BookingPerson p);
	
	public void printCheckIn(Reservation r);
	
	public void printCheckOut(BookingPerson p,Reservation r);
}
