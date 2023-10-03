import java.util.*;

public class Room {
    private String roomName;
    private static ArrayList<Room> roomsList = new ArrayList<>();

    public Room (){
        Scanner input = new Scanner(System.in);
        System.out.println("Write room to add to system");
        this.roomName = input.nextLine();
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
        for (Room obj : roomsList) {
            System.out.println(obj.getRoomName());
        }
    }

}
