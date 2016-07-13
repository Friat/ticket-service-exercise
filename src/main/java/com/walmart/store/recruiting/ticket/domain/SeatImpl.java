package com.walmart.store.recruiting.ticket.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SeatImpl implements Seat {
	
	private int seatId;
    private int levelId;
    private int seatNumber;
    private SeatHold seatHold;

	public SeatImpl(int seatId, int levelId, int i, SeatHold seatHold) {
        this.seatId = seatId;
        this.levelId = levelId;
        this.seatNumber = i;
        this.seatHold = seatHold;
    }
	
	@Override
    public SeatHold getSeatHold() {
        return seatHold;
    }

    @Override
    public void setSeatHold(SeatHold seatHold) {
        this.seatHold = seatHold;
    }

    @Override
    public int getSeatId() {
        return seatId;
    }

    @Override
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    @Override
    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public int getLevelId() {
        return levelId;
    }

    @Override
    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

	@Override
	 public boolean isAvailable() {
        return (this.getSeatHold() == null
                || (this.getSeatHold().getResearvedOn() == null || !this.getSeatHold().getResearvedOn().isPresent())
                && ChronoUnit.SECONDS.between(this.getSeatHold().getHeldOn().get(), LocalDateTime.now()) > AppSettings.TICKET_HOLD_PERIOD);
    }

}
