package com.walmart.store.recruiting.ticket.domain;

public interface SeatArrangement {

	int getLevelId();

	int getRows();

	int getSeatsInRow();

	void setLevelId(int levelId);

	void setRows(int rows);

	void setSeatsInRow(int seatsInRow);
}
