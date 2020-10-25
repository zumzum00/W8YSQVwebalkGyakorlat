package com.meiit.webalk.reservation.service;

import java.util.ArrayList;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;

public interface ReservationService {

	public void saveBookingPerson(BookingPerson p);
	
	public BookingPerson findBookingPerson(); 
	
	public ArrayList<Hotel> findAllHotels(); 
	
	public void saveReservation(Reservation r); 
	
	public ArrayList<Reservation> findAllReservations();
	
	public void checkIn();
	
	public void checkOut();
}
