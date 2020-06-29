package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());

			System.out.println("Error: Check-out date must be after Check-in date");

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
			System.out.println();
			System.out.println();
			System.out.println("Enter the data to update: ");
			System.out.print("Check in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);

			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.out.print("Invalid date format.");
		} catch (DomainException e) {
			System.out.println("Reservation error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		

		sc.close();

	}

}
