import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

public class Reservation {
    private String reservationName;
    private static ArrayList<Reservation> reservationsList = new ArrayList<>();


    public Reservation (){
        addReservationToSystem();
    }


    private static void addReservationToSystem(){  //This is some ugly shit, too long, dont care to fix
        Scanner Input = new Scanner(System.in);
        System.out.println("What group?");
        String group = Input.nextLine();
        if (Group.findGroup(group) == null) {
            System.out.println("Group does not exist");
            return;
        }
        System.out.println("What room?");
        String room = Input.nextLine();
        if (Room.findRoom(room) == null) {
            System.out.println("Room does not exist");
            return;
        }
        System.out.println("What day would you like to book? (Year first, Month second, Day third");
        LocalDate reservationDay = LocalDate.of(Input.nextInt(),Input.nextInt(),Input.nextInt());
        LocalDate today = LocalDate.now();
        if (reservationDay.isBefore(today)){
            System.out.println("Date has passed");
            return;
        }
        if (today.plusDays(7).isBefore(reservationDay)) {
            System.out.println("Date too long in future");
            return;
        }
        System.out.println("What is the duration of the reservation, '30','60','90' or '120' minutes ");
        int reservationDuration = Input.nextInt();
        /*if (reservationDuration != 30 && reservationDuration != 60 &&
              reservationDuration != 90 && reservationDuration != 120){
                System.out.println("Invalid duration input")
                return;
        }*/           //If you want to check the input this could be used, but it is super ugly

        System.out.println("At what time would you like to start the booking (Between 08:00 and 17:00, hour first then minute)");
        LocalTime startTimeReservation = LocalTime.of(Input.nextInt(), Input.nextInt());
        if (startTimeReservation.getHour() < 8 || startTimeReservation.getHour() > 17){
            System.out.println("Invalid time stamp");
            return;
        }



    }
}
