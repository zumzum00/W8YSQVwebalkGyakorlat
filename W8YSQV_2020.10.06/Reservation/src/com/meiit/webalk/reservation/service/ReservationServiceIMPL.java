package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.meiit.webalk.reservation.domain.*;

public class ReservationServiceIMPL implements ReservationService {

	private BookingPerson p;
	private Hotel h = new Hotel();
	private ArrayList<Reservation> rl = new ArrayList<Reservation>();

	@Override
	public void saveBookingPerson(BookingPerson p) {
		this.p = p;

	}

	@Override
	public BookingPerson findBookingPerson() {
		return p;
	}

	@Override
	public ArrayList<Hotel> findAllHotels() {
		BigDecimal b1 = new BigDecimal("500");
		BigDecimal b2 = new BigDecimal("1500");
		BigDecimal b3 = new BigDecimal("200");
		BigDecimal b4 = new BigDecimal("500");

		ArrayList<Hotel> lh = new ArrayList<Hotel>();
		h.setName("Hilton");
		h.setFloors(new ArrayList<Floor>());
		Floor f = new Floor();
		f.setFloorNumber(1);
		f.setWings(new ArrayList<Wing>());
		h.getFloors().add(f);
		Wing w = new Wing();
		w.setType(WingType.NORTH);
		f.getWings().add(w);
		w.setFloor(f);
		f.setHotel(h);

		Room r = new Room();
		r.setWing(w);
		r.setBeds(2);
		r.setNumber(1);
		r.setPrice(b1);

		Room r1 = new Room();
		r1.setWing(w);
		r1.setBeds(4);
		r1.setNumber(2);
		r1.setPrice(b2);

		Room r2 = new Room();
		r2.setWing(w);
		r2.setBeds(1);
		r2.setNumber(3);
		r2.setPrice(b3);

		Room r3 = new Room();
		r3.setWing(w);
		r3.setBeds(2);
		r3.setNumber(4);
		r3.setPrice(b4);

		ArrayList<Room> rooms = new ArrayList<Room>();
		w.setRooms(rooms);
		rooms.add(r);
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		lh.add(h);
		return lh;
	}

	@Override
	public void saveReservation(Reservation r) {
		LocalDateTime now = LocalDateTime.now();
		r.setFrom(now);
		rl.add(r);
	}

	@Override
	public ArrayList<Reservation> findAllReservations() {
		return rl;
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkOut() {
		System.out.println("Few days later!\n");
		System.out.println("Chech out!");

	}

}
