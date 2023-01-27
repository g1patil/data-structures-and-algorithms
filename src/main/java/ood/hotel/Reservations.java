package ood.hotel;

import java.util.List;

public interface Reservations {
    Booking makeReservation(Booking booking);
    List<Booking> getAllReservations();
    Booking updateReservation(Long id, Booking booking);
    Booking getReservation(Long bookingId);
    Booking cancelReservation(Long bookingId);
}
