package com.meiit.webalk.reservation;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.meiit.webalk.reservation.domain.*;
import com.meiit.webalk.reservation.service.*;
import com.meiit.webalk.reservation.view.*;

public class App {

	private ReservationService service;
	private View view;

	public App(ReservationService service, View view) {
		this.service = service;
		this.view = view;
	}

	public static void main(String[] args) {
		ReservationService service = new ReservationServiceIMPL();
		View view = new ViewIMPL();
		App app = new App(service, view);
		app.book();
		app.checkIn();
		app.checkOUT();

	}

	public void createBookingPerson() {
		BookingPerson p = view.readBookingPerson();
		service.saveBookingPerson(p);
	}

	public void book() {
		createBookingPerson();
		BookingPerson p = service.findBookingPerson();
		view.printWelcomeMessage(p);
		view.printBalance(p);
		//Lust<> and nameing
		ArrayList<Hotel> l = new ArrayList<Hotel>();
		l = service.findAllHotels();
		view.printRooms(l);

	}

	public void checkIn() {
		BookingPerson p = service.findBookingPerson();
		ArrayList<Hotel> l = new ArrayList<Hotel>();
		ArrayList<Reservation> rl = new ArrayList<Reservation>();
		Reservation r = new Reservation();
		Room room = new Room();
		int dont;
		boolean asd = true;
		l = service.findAllHotels();
		while (asd == true) {
			room = view.selectRoom(l);
			if (room == null) {
				asd = false;
			} else {
				dont = p.getBalance().compareTo(room.getPrice());
				if (dont == -1) {
					view.printNotEnoughBalance(p);
					view.printRooms(l);
					view.selectRoom(l);
				} else {
					r.setRoom(room);
					r.setPerson(p);
					r.setAmount(r.getRoom().getPrice());
					service.saveReservation(r);
					asd = false;
				}
			}
		}
		p.setBalance(p.getBalance().subtract(r.getAmount()));
		rl = service.findAllReservations();
		for (Reservation reservation : rl) {
			view.printReservationSaved(reservation);
			
		}
		view.printCheckIn(r);
		System.out.println(p.getBalance());
	}

	public void checkOUT() {
		BookingPerson p = service.findBookingPerson();
		ArrayList<Reservation> rl = service.findAllReservations()
			view.printCheckOut(p, r);
	}

}
