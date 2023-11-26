import java.util.ArrayList;
import java.time.LocalDateTime;
public class ReservationOverview { //Fuck this shit we'll do it later
    private LocalDateTime today = LocalDateTime.now(); //Will be used to check if reservation is within today
    public static void printReservationOverview() {

        System.out.println(Room.getRoomReservations());
        /*
        for (Reservation res : Reservations) {
            if (Reservations.getReservationDayAndTime) {
                Reservations.remove(res);
            }
        }
        System.out.println("List of all reservations: ");
        for (Reservation obj : Reservations) {
            System.out.println(" - " + Reservations);
        }
        */
    }
}
