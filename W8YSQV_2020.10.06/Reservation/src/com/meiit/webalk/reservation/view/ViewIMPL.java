package com.meiit.webalk.reservation.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.*;

public class ViewIMPL implements View {

	Scanner sc = new Scanner(System.in);

	@Override
	public BookingPerson readBookingPerson() {
		System.out.println("Whats yout name?");
		BookingPerson p = new BookingPerson();
		p.setName(sc.next());
		System.out.println("How much mney do you have (More than 0) ?");
		p.setBalance(sc.nextBigDecimal());
		System.out.println("What is your currency? (HUF,EUR or USD)");
		p.setCurrency(Currency.valueOf(sc.next()));
		return p;
	}

	@Override
	public void printWelcomeMessage(BookingPerson p) {
		System.out.println("Welcome " + p.getName());

	}

	@Override
	public void printBalance(BookingPerson p) {
		System.out.println("Your balance is: " + p.getBalance() + p.getCurrency());

	}

	@Override
	public void printRooms(ArrayList<Hotel> l) {
		System.out.println("Where are you want to book? (choose a number or press q for quit)");

		int roomi = 0;
		for (int i = 0; i < l.size(); i++) {

			ArrayList<Floor> floor = l.get(i).getFloors();

			for (int j = 0; j < floor.size(); j++) {

				ArrayList<Wing> wing = floor.get(j).getWings();

				for (int k = 0; k < wing.size(); k++) {

					ArrayList<Room> room = wing.get(k).getRooms();

					for (int m = 0; m < room.size(); m++, roomi++) {
						System.out.println((roomi + 1) + ": Hotel name: " + l.get(i).getName() + ", Floor: "
								+ floor.get(j).getFloorNumber() + ", Wing: " + wing.get(k).getType() + ", Room number: "
								+ room.get(m).getNumber() + ", Beds: " + room.get(m).getBeds() + ", Room Price: "
								+ room.get(m).getPrice() + "\n");

					}

				}

			}

		}

	}

	@Override
	public Room selectRoom(ArrayList<Hotel> l) {
		String b;
		Room r = null;
		b = sc.next();

		int roomi = 0;
		for (int i = 0; i < l.size(); i++) {

			ArrayList<Floor> floor = l.get(i).getFloors();

			for (int j = 0; j < floor.size(); j++) {

				ArrayList<Wing> wing = floor.get(j).getWings();

				for (int k = 0; k < wing.size(); k++) {

					ArrayList<Room> room = wing.get(k).getRooms();

					for (int m = 0; m < room.size(); m++, roomi++) {
						if (b.equals("q")) {
							return r;
						}
						if (Integer.parseInt(b) == (roomi + 1)) {
							r = room.get(m);
						}
					}

				}

			}

		}

		return r;
	}

	@Override
	public void printReservationSaved(Reservation r) {
		System.out.println("The reservation Succesfuly saved!");
		System.out.println("Reservation details: Hilton, Floor: " + r.getRoom().getWing().getFloor().getFloorNumber() + " , Wing:"
				+ r.getRoom().getWing().getType() + " , Room Number: " + r.getRoom().getNumber() + ", Beds: "
				+ r.getRoom().getBeds() + ", Room price: " + r.getRoom().getPrice());
	}

	@Override
	public void printNotEnoughBalance(BookingPerson p) {
		System.out.println("Sorry you don't have enough balance please choose another room!");
		System.out.println("Your Balance is: " + p.getBalance() + p.getCurrency());
	}

	@Override
	public void printCheckIn(Reservation r) {
		System.out.println("Hilton, Floor: " + r.getRoom().getWing().getFloor().getFloorNumber() + " , Wing:"
				+ r.getRoom().getWing().getType() + " , Room Number: " + r.getRoom().getNumber() + ", Beds: "
				+ r.getRoom().getBeds() + ", Room price: " + r.getRoom().getPrice());
	}

	@Override
	public void printCheckOut(BookingPerson p, Reservation r) {
		LocalDateTime now = LocalDateTime.now();
		if (r.getTo().compareTo(now) == -1) {
			System.out.println("Few days later!");
			System.out.println("Check out!");
			System.out.println("Your balance is " + p.getBalance() + p.getCurrency());
		}
	}

}
