import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private String roomName;
    private static ArrayList<Room> roomsList = new ArrayList<>();
    private static ArrayList<Reservation> roomReservations = new ArrayList<>();

    public Room (){
        Scanner input = new Scanner(System.in);
        System.out.println("Write room to add to system");
        this.roomName = input.nextLine();
        roomsList.add(this);
        System.out.println("Room added");
    }

    public Room (String roomName){
        this.roomName = roomName;
        roomsList.add(this);
    }

    public String getRoomName() {
        return roomName;
    }

    public static Room findRoom(String name) {
        for (Room obj : roomsList) {
            if (obj.roomName.equals(name)){
                return obj;
            }
        }
        return null;
    }

    public static void printRooms() {
        System.out.println("List of all registered rooms: ");
        for (Room obj : roomsList) {
            System.out.println(" - " + obj.getRoomName());
        }
    }

    public static ArrayList<Reservation> getRoomReservations() {
        return roomReservations;
    }

    public static void addReservationToList(Reservation res) {
        Room.roomReservations.add(res);
    }

    // ********** TASK FIVE ***********
    public static void printRoomReservations() {
        System.out.println("List of all registered reservations: ");
        for (Reservation obj : roomReservations) {
            System.out.println(" - " + obj.getReservationGroup() + " has booked: " + obj.getRoomName() + " in the time interval: " + obj.getReservationDayAndTime() + " to " + obj.getReservationEndTime()); //This prints nothing :/
        }
    }

    public static void printTodaysRoomReservations() {
        
        System.out.println("List of all registered reservations: ");
        for (Reservation obj : roomReservations) {
            System.out.println(" - " + obj.getReservationGroup() + " has booked: " + obj.getRoomName() + " in the time interval: " + obj.getReservationDayAndTime() + " to " + obj.getReservationEndTime()); //This prints nothing :/
        }
    }
}
