package com.walmart.store.recruiting.ticket.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * This POJO contains the data relevant to a successful seat hold request,
 * including the seat hold id which may be used later to permanently reserve the
 * seats.
 */
public class SeatHoldImpl implements SeatHold {

	private int seatHoldId;
	private Optional<LocalDateTime> heldOn;
	private Optional<LocalDateTime> researvedOn;
	private String researvationCode;

	public SeatHoldImpl() {
		this.heldOn = Optional.of(LocalDateTime.now());
	}

	@Override
	public void researve() {
		this.researvedOn = Optional.of(LocalDateTime.now());
		this.researvationCode = "" + this.researvedOn.get().getYear() + this.researvedOn.get().getMonth()
				+ this.researvedOn.get().getDayOfMonth() + this.researvedOn.get().getHour()
				+ this.researvedOn.get().getMinute() + this.researvedOn.get().getSecond()
				+ this.researvedOn.get().getNano();
	}

	@Override
	public int getSeatHoldId() {
		return seatHoldId;
	}

	@Override
	public Optional<LocalDateTime> getHeldOn() {
		return heldOn;
	}

	@Override
	public Optional<LocalDateTime> getResearvedOn() {
		return researvedOn;
	}
	
	@Override
    public String getResearvationCode() {
        return researvationCode;
    }

	@Override
	public void addSeats(List<Seat> seats) {
		seats.stream().forEach(s -> s.setSeatHold(this));
	}

	@Override
	public void setSeatHoldId(int seatHoldId) {
		this.seatHoldId = seatHoldId;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//
//		SeatHoldImpl seatHold = (SeatHoldImpl) o;
//
//		return seatHoldId.equals(seatHold.id);
//	}
	
	
}
