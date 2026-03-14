package ood.hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

class ReservationsImplTest {

    private ReservationsImpl reservations;

    @BeforeEach
    void setUp(){
        reservations = new ReservationsImpl();
    }

    @Test
    void makeReservation(){
        Booking booking = new Booking(
                new Date(),
                "jivan",
                new Room(
                        RoomType.KING
                ),
                true
        );

        reservations.makeReservation(booking);
        Assertions.assertTrue(reservations.getAllReservations().contains(booking));
    }

    @Test
    void getAllReservations(){
        List.of(1L,2L,3L).forEach(
                n -> {
                    Booking booking = new Booking(
                            new Date(),
                            "jivan",
                            new Room(
                                    RoomType.KING
                            ),
                            true
                    );
                    reservations.makeReservation(booking);
                }
        );
        System.out.println(
                reservations.getAllReservations()
        );
        Assertions.assertTrue( reservations.getAllReservations().size() == 3);
    }

    @Test
    void cancelReservation(){
        Booking booking = new Booking(
                new Date(),
                "jivan",
                new Room(
                        RoomType.KING
                ),
                true
        );

        reservations.makeReservation(booking);
        reservations.cancelReservation(booking.getBookingId());
        Assertions.assertFalse(reservations.getAllReservations().contains(booking));
    }


    @Test
    void getReservation(){
        Booking booking = new Booking(
                new Date(),
                "jivan",
                new Room(
                        RoomType.KING
                ),
                true
        );

        Booking confirmedBooking = reservations.makeReservation(booking);
        Assertions.assertEquals(confirmedBooking , booking);
    }
}