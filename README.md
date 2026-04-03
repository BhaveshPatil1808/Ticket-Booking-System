# 🎟️ Ticket Booking System

[![Java](https://img.shields.io/badge/Java-21-blue?logo=java)]
[![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-green)]
[![Database](https://img.shields.io/badge/Database-MySQL-lightblue?logo=mysql)]

A console-based Ticket Booking System built using Java, JDBC, and MySQL.
It allows users to register/login, browse shows, book/cancel tickets, and view bookings.
Admins can add shows, view all shows, and monitor bookings.

--------------------------------------------------

## ✨ Overview

- Users can register, log in, and manage bookings
- Admins can create and manage shows
- Real-time seat booking and cancellation
- Booking tracking and seat availability updates

--------------------------------------------------

## 🛠️ Tech Stack

- Java 21
- JDBC
- MySQL
- Console-based UI

--------------------------------------------------

## 🚀 Features

USER FEATURES
- Register & Login
- View Shows
- Book Tickets
- Cancel Tickets
- View Booking History

ADMIN FEATURES
- Add Shows
- View All Shows
- View All Bookings

SYSTEM FEATURES
- Auto seat updates
- Booking tracking
- Role-based access (Admin/User)

--------------------------------------------------

## ⚙️ Prerequisites

- Java 21+
- MySQL running locally
- JDBC Driver (MySQL Connector/J)

--------------------------------------------------

## 🧑‍💻 Getting Started

1. Clone Repository

git clone https://github.com/BhaveshPatil1808/Ticket-Booking-System.git
cd Ticket-Booking-System

--------------------------------------------------

2. Configure Database

Edit DBConnection.java:

String username = "root";
String password = "yourpassword";
String url = "jdbc:mysql://localhost:3306/ticket_system";

--------------------------------------------------

3. Create Database

CREATE DATABASE ticket_system;

USE ticket_system;

CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL,
  role VARCHAR(20) NOT NULL
);

CREATE TABLE shows (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  source VARCHAR(100),
  destination VARCHAR(100),
  show_date DATE,
  show_time TIME,
  total_seats INT,
  available_seats INT
);

CREATE TABLE bookings (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  show_id INT,
  seats_booked INT,
  total_amount DOUBLE,
  booking_date DATE,
  status VARCHAR(20),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (show_id) REFERENCES shows(id)
);

--------------------------------------------------

4. Compile Project

javac -d bin src/com/ticketBooking/**/*.java

--------------------------------------------------

5. Run Application

java -cp bin com.ticketBooking.Map.MainApp

--------------------------------------------------

## 💬 Usage

ADMIN MENU
- Add Show
- View All Shows
- View All Bookings

USER MENU
- View Shows
- Book Ticket
- Cancel Ticket
- My Bookings

--------------------------------------------------

## 📂 Project Structure

Ticket-Booking-System/
│
├── src/
│   └── com/
│       └── ticketBooking/
│           ├── Dao/
│           │   ├── BookingDAO.java
│           │   ├── ShowDAO.java
│           │   └── UserDAO.java
│           │
│           ├── DBConnection/
│           │   └── DBConnection.java
│           │
│           ├── Entity/
│           │   ├── Users.java
│           │   ├── Show.java
│           │   └── Booking.java
│           │
│           ├── Service/
│           │   ├── interfaces/
│           │   └── implementations/
│           │
│           ├── Utility/
│           │   └── MenuApp.java
│           │
│           └── Map/
│               └── MainApp.java
│
└── README.md

--------------------------------------------------

## 🔮 Future Improvements

- Add web UI (Spring Boot + Thymeleaf)
- Encrypt passwords
- Booking analytics dashboard
- Docker support
- Dynamic pricing

--------------------------------------------------

## 👨‍💻 Author

Bhavesh Patil

--------------------------------------------------

## ⭐ Support

Give this project a star if you like it!
