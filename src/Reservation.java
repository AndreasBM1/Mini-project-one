import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {

    private String reservationName;
    private static ArrayList<Reservation> reservationsList = new ArrayList<>();

    public Reservation (){
        Scanner input = new Scanner(System.in);
        System.out.println("Write reservation to add to system");
        this.reservationName = input.nextLine();
        reservationsList.add(this);
    }
}
