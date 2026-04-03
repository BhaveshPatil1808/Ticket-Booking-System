package com.ticketBooking.Utility;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.ticketBooking.Entity.Booking;
import com.ticketBooking.Entity.Show;
import com.ticketBooking.Entity.Users;
import com.ticketBooking.Service.*;

public class MenuApp {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static UserService userService = new UserServiceImpl();
    static ShowService showService = new ShowServiceImpl();
    static BookingService bookingService = new BookingServiceImpl();

    public void menu() {

        while (true) {
            try {
                System.out.println("\n===== TICKET BOOKING SYSTEM =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 🔐 REGISTER
    static void register() throws Exception {
        System.out.print("Username: ");
        String username = br.readLine();

        System.out.print("Password: ");
        String password = br.readLine();

        System.out.print("Role (ADMIN/USER): ");
        String role = br.readLine().toUpperCase();

        Users user = new Users(0, username, password, role);

        if (userService.register(user)) {
            System.out.println("✅ Registered Successfully!");
        } else {
            System.out.println("❌ Registration Failed!");
        }
    }

    // 🔐 LOGIN
    static void login() throws Exception {
        System.out.print("Username: ");
        String username = br.readLine();

        System.out.print("Password: ");
        String password = br.readLine();

        Users user = userService.login(username, password);

        if (user == null) {
            System.out.println("❌ Invalid Credentials!");
            return;
        }

        if (user.getRole().equals("ADMIN")) {
            adminMenu();
        } else {
            userMenu(user.getId());
        }
    }

    // 👨‍💻 ADMIN MENU
    static void adminMenu() throws Exception {
        while (true) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add Show");
            System.out.println("2. View All Shows");
            System.out.println("3. View All Bookings");
            System.out.println("4. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    addShow();
                    break;

                case 2:
                    List<Show> shows = showService.getAllShows();
                    for (Show s : shows) {
                        s.display();
                    }
                    break;

                case 3:
                    List<Booking> bookings = bookingService.getAllBookings();
                    for (Booking b : bookings) {
                        b.display();
                    }
                    break;

                case 4:
                    return;
            }
        }
    }

    // ➕ ADD SHOW
    static void addShow() throws Exception {

        System.out.print("Show Name: ");
        String name = br.readLine();

        System.out.print("Source: ");
        String source = br.readLine();

        System.out.print("Destination: ");
        String dest = br.readLine();

        System.out.print("Date (yyyy-mm-dd): ");
        Date date = Date.valueOf(br.readLine());

        System.out.print("Time (hh:mm:ss): ");
        Time time = Time.valueOf(br.readLine());

        System.out.print("Total Seats: ");
        int total = Integer.parseInt(br.readLine());

        Show show = new Show(0, name, source, dest, date, time, total, total);

        if (showService.addShow(show)) {
            System.out.println("✅ Show Added!");
        } else {
            System.out.println("❌ Failed!");
        }
    }

    // 👤 USER MENU
    static void userMenu(int userId) throws Exception {
        while (true) {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. View Shows");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. My Bookings");
            System.out.println("5. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {

                case 1:
                    List<Show> shows = showService.getAllShows();
                    for (Show s : shows) {
                        s.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter Show ID: ");
                    int showId = Integer.parseInt(br.readLine());

                    System.out.print("Seats: ");
                    int seats = Integer.parseInt(br.readLine());

                    bookingService.bookTicket(userId, showId, seats);
                    break;

                case 3:
                    System.out.print("Enter Booking ID: ");
                    int bookingId = Integer.parseInt(br.readLine());

                    bookingService.cancelTicket(bookingId);
                    break;

                case 4:
                    List<Booking> list = bookingService.getUserBookings(userId);
                    for (Booking b : list) {
                        b.display();
                    }
                    break;

                case 5:
                    return;
            }
        }
    }
}
