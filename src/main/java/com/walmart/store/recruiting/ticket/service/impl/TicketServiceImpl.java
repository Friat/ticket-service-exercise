package com.walmart.store.recruiting.ticket.service.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.walmart.store.recruiting.ticket.domain.DataAccess;
import com.walmart.store.recruiting.ticket.domain.Seat;
import com.walmart.store.recruiting.ticket.domain.SeatHold;
import com.walmart.store.recruiting.ticket.domain.SeatHoldImpl;
import com.walmart.store.recruiting.ticket.domain.Venue;
import com.walmart.store.recruiting.ticket.service.TicketService;

/**
 * A ticket service implementation.
 */
public class TicketServiceImpl implements TicketService {

	private int seatsAvailable;
	private int seatsReserved;
	private Map<String, SeatHoldImpl> seatHoldMap = new HashMap<>();

	public TicketServiceImpl(Venue venue) {
		seatsAvailable = venue.getMaxSeats();
	}

	public TicketServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		return (int) DataAccess.getInstance().getAllSeats().stream()
				.filter(s -> (!venueLevel.isPresent() || s.getLevelId() == venueLevel.get()) && s.isAvailable())
				.count();
	}

	@Override
	public Optional<SeatHold> findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel) {
		List<Seat> seats = DataAccess.getInstance().getAllSeats().stream()
				.filter(s -> s.isAvailable() && (!minLevel.isPresent() || s.getLevelId() >= minLevel.get())
						&& (!maxLevel.isPresent() || s.getLevelId() <= maxLevel.get()))
				.sorted(Comparator.comparing(s -> s.getLevelId())).limit(numSeats).collect(Collectors.toList());

		Optional<SeatHold> optionalSeatHold = Optional.empty();
		SeatHold seatHold = new SeatHoldImpl();

		optionalSeatHold = Optional.of(seatHold);

		return optionalSeatHold;
	}

	@Override
	public String reserveSeats(int seatHoldId) {
		SeatHold seatHold = DataAccess.getInstance().getSeatHold(seatHoldId);
		seatHold.researve();
		return seatHold.getResearvationCode();
	}

}
