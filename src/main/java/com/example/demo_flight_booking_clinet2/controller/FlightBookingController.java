package com.example.demo_flight_booking_clinet2.controller;

import com.example.demo_flight_booking_clinet2.model.FlightBooking;
import com.example.demo_flight_booking_clinet2.model.FlightResponseMessage;
import com.example.demo_flight_booking_clinet2.service.FlightBookingClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class FlightBookingController {

    @Autowired
    FlightBookingClientService flightBookingClientService;

    @PostMapping("/chat")
    @CrossOrigin(origins = "http://localhost:3000")
    public FlightResponseMessage chat(@RequestBody String message) {
        System.out.println("request received : " + message);
        FlightResponseMessage response = flightBookingClientService.processInput(message);
        System.out.println("response sent: " + response);
        //convert below to json
        return response;
    }
}
