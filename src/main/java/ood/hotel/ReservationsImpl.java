package ood.hotel;

import java.util.*;

/**
 * My attempt on building hotel.com system
 * */
public class ReservationsImpl implements Reservations {

    private static Map<Long,Booking> reservations;
    private static Long bookingId;
    private static Double balance;
    private static int totalRooms;

    public ReservationsImpl(){
        reservations = new HashMap<>();
        bookingId = 1L;
        balance = 0D;
        totalRooms = 0;
    }

    @Override
    public Booking makeReservation(Booking booking){
        double total = getPrice(booking.getRoom().getType());
        balance+=total;
        totalRooms--;
        booking.setTotal( total );
        Long id = bookingId++;
        booking.setBookingId(id);
        reservations.put( id , booking);
        return reservations.get(id);
    }

    @Override
    public List<Booking> getAllReservations(){
        return new ArrayList<>(reservations.values());
    }

    @Override
    public Booking updateReservation(Long id, Booking booking){
        Booking oldBooking = reservations.get(id);
        reservations.remove(id);
        return makeReservation(booking);
    }

    @Override
    public Booking getReservation(Long bookingId){
        return reservations.get(bookingId);
    }

    @Override
    public Booking cancelReservation(Long bookingId){
        totalRooms++;
        return reservations.remove(bookingId);

    }

    private double getPrice(final RoomType roomType){
        return switch(roomType){
            case KING -> 100D;
            case QUEEN -> 200D;
            case APARTMENT -> 500;
            default -> 0D;
        };
    }
}
