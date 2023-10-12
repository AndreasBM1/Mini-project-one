import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private String roomName;
    private static ArrayList<Room> roomsList = new ArrayList<>();
    private ArrayList<Reservation> roomReservations = new ArrayList<>();

    public Room (){
        Scanner input = new Scanner(System.in);
        System.out.println("Write room to add to system");
        this.roomName = input.nextLine();
        roomsList.add(this);
        System.out.println("Room added");
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

    public ArrayList<Reservation> getRoomReservations() {
        return roomReservations;
    }
}
