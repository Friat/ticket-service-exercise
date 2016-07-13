package com.walmart.store.recruiting.ticket.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SeatHold {

	int getSeatHoldId();

	void setSeatHoldId(int seatHoldId);

	Optional<LocalDateTime> getHeldOn();

	Optional<LocalDateTime> getResearvedOn();
	void addSeats(List<Seat> seats);
    void researve();
	String getResearvationCode();

	}
