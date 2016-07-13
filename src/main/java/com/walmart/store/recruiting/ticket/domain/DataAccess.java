package com.walmart.store.recruiting.ticket.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DataAccess {

	private static DataAccess instance;
	private static List<SeatArrangement> seatingArrangements = new ArrayList<>();
	private static List<Seat> seats = new ArrayList<>();
	private static List<SeatHold> seatHolds = new ArrayList<>();

	public static DataAccess getInstance() {
		if (instance == null) {
			instance = new DataAccess();
			initData();
		}

		return instance;
	}

	private static void initData() {
		seatingArrangements.add(new SeatArrangementImpl(1, 20, 100));
		seatingArrangements.add(new SeatArrangementImpl(2, 15, 100));
		int seatId = 1;
		for (SeatArrangement seatingArrangement : seatingArrangements) {
			int seatNumber = 1;
			for (int i = 0; i < seatingArrangement.getSeatsInRow() * seatingArrangement.getRows(); i++) {
				seats.add(new SeatImpl(seatId++, seatingArrangement.getLevelId(),
						seatingArrangement.getSeatsInRow() + seatNumber++, null));
			}
		}
	}
	 public List<SeatHold> getAllSeatHolds() {
	        return seatHolds;
	    }

	    public SeatHold getSeatHold(int setHoldId) {
	        return seatHolds.stream().filter(sh -> sh.getSeatHoldId() == setHoldId).findFirst().get();
	    }

	    public List<Seat> getAllSeats() {
	        return seats;
	    }

	    public void addSeatHold(SeatHold seatHold) {
	        Optional<Integer> maxId = seatHolds.stream().map(sh -> sh.getSeatHoldId()).max(Comparator.comparing(shi -> shi));
	        if (maxId.isPresent()) {
	            seatHold.setSeatHoldId(maxId.get());
	        } else {
	            seatHold.setSeatHoldId(1);
	        }
	        seatHolds.add(seatHold);
	    }
	
}
