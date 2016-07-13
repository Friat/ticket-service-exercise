package com.walmart.store.recruiting.main;

import java.util.Optional;

import com.walmart.store.recruiting.ticket.domain.SeatHold;
import com.walmart.store.recruiting.ticket.service.TicketService;
import com.walmart.store.recruiting.ticket.service.impl.TicketServiceImpl;

public class Main {
	
	    public static void main(String[] args) {
	        TicketService ticketService = new TicketServiceImpl();
	        System.out.println("Total Available level 1 seat: " + ticketService.numSeatsAvailable(Optional.of(1)));
	        System.out.println("Total Available level 2 seat: " + ticketService.numSeatsAvailable(Optional.of(2)));
	        SeatHold seatHold = ticketService.findAndHoldSeats(100, Optional.of(1), Optional.of(1));
	        System.out.println("Total Available level 1 seat: " + ticketService.numSeatsAvailable(Optional.of(1)));
	        //email param is irrelevant here
	        ticketService.reserveSeats(seatHold.getSeatHoldId());
	        System.out.println("Total Available level 1 seat: " + ticketService.numSeatsAvailable(Optional.of(1)));
	        System.out.println("Total Available level 2 seat: " + ticketService.numSeatsAvailable(Optional.of(2)));
	    }
	}

