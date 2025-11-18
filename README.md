# **Flight Booking Application**
This project is a Flight Booking System built using Spring Boot + MySQL + JWT Authentication.
Users can search flights, book tickets, view booking history, and cancel bookings.
Admins can manage airlines and flight inventory.

## 1. Project Overview

This application exposes REST APIs that allow:

### User Features

- Search for flights (by date, origin, destination)

- View airline name, logo, flight timings, and price

- Book flight tickets

- Passenger details

- Meal preference

- Seat count

- Receive a system-generated PNR

- View booking history using email ID

- View ticket using PNR

- Cancel booked ticket (only before 24 hours of departure)

### Tech Stack

- Spring Boot 3

- Spring Security + JWT

- MySQL

- JPA

- JUnit + Mockito for testing

- Lombok

## 2. REST API Endpoints
### Flight Inventory (Admin)
`POST	/api/v1.0/flight/airline/inventory/add`

### Flight Search (User)
`POST	/api/v1.0/flight/search`

### Booking (User)

`POST	/api/v1.0/flight/booking/book`

`GET	/api/v1.0/flight/booking/ticket/{pnr}`	

`GET	/api/v1.0/flight/booking/history/{email}`	

`DELETE	/api/v1.0/flight/booking/cancel/{pnr}`

## 3. Postman Screenshots

### 1) Register User
<img width="2864" height="1260" alt="image" src="https://github.com/user-attachments/assets/e7744080-6476-4ea3-87d8-0dec00647cd4" />

### 2) User Login
<img width="2837" height="1351" alt="image" src="https://github.com/user-attachments/assets/a3685045-0dff-4b7b-8fc5-13bec6fb4407" />

### 3) Add Airline
<img width="2846" height="1333" alt="image" src="https://github.com/user-attachments/assets/5365681c-d39a-4170-91c5-ce58d8c1007a" />

### 4) Add Inventory
<img width="2857" height="1505" alt="image" src="https://github.com/user-attachments/assets/4027cc26-e4f1-481b-8fd2-629d25e2fff0" />

### 5) Search Inventory
<img width="2871" height="1551" alt="image" src="https://github.com/user-attachments/assets/bdda17ab-87a0-4411-9254-caecb7eeb990" />

### 6) Book Ticket
<img width="2867" height="1410" alt="image" src="https://github.com/user-attachments/assets/34e45c3e-0caa-4279-b5a8-9a18f97c6b57" />

### 7)Get Booking history by email
<img width="2870" height="1506" alt="image" src="https://github.com/user-attachments/assets/08e508d3-cf15-470a-b698-98cc8e99c8e9" />

### 8)Delete ticket
<img width="2866" height="1298" alt="image" src="https://github.com/user-attachments/assets/5fdcd3b7-5dc4-47c1-956c-4f8cd8733b54" />






## 4. Database Schema & Screenshots (MySQL)

### 1) Users Table
<img width="1918" height="1487" alt="image" src="https://github.com/user-attachments/assets/fe32195c-ce36-4c4a-954a-4e5b047b2af6" />

### 2) Airline Table
<img width="1913" height="1512" alt="image" src="https://github.com/user-attachments/assets/834aad86-2169-4f17-b9e0-d5fc9a969351" />

### 3) Flight_inventory Table
<img width="1921" height="1498" alt="image" src="https://github.com/user-attachments/assets/cd64e061-5e01-408c-a920-822e20a122d3" />

### 4) Booking Table
<img width="1926" height="1498" alt="image" src="https://github.com/user-attachments/assets/aa29d5b3-38b6-497a-8fbe-123c8c11e64e" />

### 5) Passenger Table
<img width="1906" height="1494" alt="image" src="https://github.com/user-attachments/assets/8cbd31ac-5af8-44fd-b5c9-6530de9cb602" />







