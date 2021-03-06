package com.walmart.store.recruiting.ticket.service.impl;

import com.walmart.store.recruiting.ticket.service.TicketService;
import com.walmart.store.recruiting.ticket.domain.SeatHold;
import com.walmart.store.recruiting.ticket.domain.SeatHoldImpl;
import com.walmart.store.recruiting.ticket.domain.Venue;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * A few basic tests for the TicketService.
 */
public class TicketServiceImplTest {

    private static final Venue TEN_SEAT_VENUE = new Venue(0, 2, 5);
    private TicketService ticketService;

    @Before
    public void init() {
        ticketService = new TicketServiceImpl(TEN_SEAT_VENUE);
    }

    @Test
    public void testSimpleSeatHold() {
        Optional<SeatHold> hold = ticketService.findAndHoldSeats(100, Optional.of(1), Optional.of(1));
        assertTrue(hold.isPresent());
        assertNotNull(hold.get().getSeatHoldId());
        assertEquals(1, hold.get().getNumSeats());
        assertEquals(9, ticketService.numSeatsAvailable(venueLevel));

        hold = ticketService.findAndHoldSeats(100, Optional.of(1), Optional.of(1));
        assertTrue(hold.isPresent());
        assertNotNull(hold.get().getSeatHoldId());
        assertEquals(5, hold.get().getNumSeats());
        assertEquals(4, ticketService.numSeatsAvailable(venueLevel));
    }

    @Test
    public void testReserveSeats() {
        Optional<SeatHold> hold = ticketService.findAndHoldSeats(100, Optional.of(1), Optional.of(1));
        assertTrue(hold.isPresent());
        assertNotNull(hold.get().getSeatHoldId());
        assertEquals(5, hold.get().getNumSeats());
        assertEquals(5, ticketService.numSeatsAvailable(venueLevel));

        Optional<String> reservationId = ticketService.reserveSeats(hold.get().getId());
        assertTrue(reservationId.isPresent());
        assertEquals(hold.get().getSeatHoldId(), reservationId.get());
    }

    @Test
    public void testReserveSeatsWithInvalidHold() {
        Optional<String> reservationId = ticketService.reserveSeats("AAAA");
        assertFalse(reservationId.isPresent());
    }

    @Test
    public void testMaxSeatHold() {
        Optional<SeatHold> hold = ticketService.findAndHoldSeats(100, Optional.of(5), Optional.of(1));
        assertTrue(hold.isPresent());
        assertNotNull(hold.get().getSeatHoldId());
        assertEquals(10, hold.get().getNumSeats());
    }

    @Test
    public void testEmptySeatHoldReturnedWhenRequestExceedsCapacity() {
        Optional<SeatHold> hold = ticketService.findAndHoldSeats(100, Optional.of(11), Optional.of(1));
        assertTrue(!hold.isPresent());
    }

    @Test
    public void testEmptySeatHoldReturnedWhenVenueIsFull() {
        testMaxSeatHold();
        Optional<SeatHold> hold = ticketService.findAndHoldSeats(100, Optional.of(16), Optional.of(1));
        assertTrue(!hold.isPresent());
    }

}
