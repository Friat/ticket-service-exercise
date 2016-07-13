package com.walmart.store.recruiting.ticket.domain;

public interface Seat {

	SeatHold getSeatHold();

    void setSeatHold(SeatHold seatHold);
    
    int getSeatId();

    void setSeatId(int seatId);

    int getSeatNumber();
    int getLevelId();

    void setLevelId(int levelId);

    void setSeatNumber(int seatNumber);
    public boolean isAvailable();
}
