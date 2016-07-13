package com.walmart.store.recruiting.ticket.domain;

public class SeatArrangementImpl implements SeatArrangement {

	private int levelId;
	private int rows;
	private int seatsInRow;

	public SeatArrangementImpl(int levelId, int rows, int seatsInRow) {
		this.levelId = levelId;
		this.rows = rows;
		this.seatsInRow = seatsInRow;

	}

	@Override
	public int getLevelId() {
		return levelId;
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getSeatsInRow() {
		// TODO Auto-generated method stub
		return seatsInRow;
	}

	@Override
	public void setLevelId(int levelId) {
		this.levelId = levelId;

	}

	@Override
	public void setRows(int rows) {
		this.rows = rows;

	}

	@Override
	public void setSeatsInRow(int seatsInRow) {
		this.seatsInRow = seatsInRow;

	}

}
