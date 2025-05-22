package com.example.demo_flight_booking_clinet2.model;


import java.util.List;

public class FlightResponseMessage {
    String message;
    List<FlightBooking> bookings;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FlightBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<FlightBooking> bookings) {
        this.bookings = bookings;
    }
}
