package ood.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class Booking {
    private Long bookingId;
    private Date date;
    private String guestName;
    private Room room;
    private Double total;
    private boolean confirmed;

    public Booking(Date date, String guestName, Room room, boolean confirmed){
        this.date = date;
        this.guestName = guestName;
        this.room = room;
        this.confirmed = confirmed;
    }
}

@AllArgsConstructor
@Data
class Room {
    RoomType type;
}

enum RoomType {
    KING,
    QUEEN,
    APARTMENT,
    SINGLE
}
