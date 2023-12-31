import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reservation {
    private static final ArrayList<Integer> validDurations = new ArrayList<>(Arrays.asList(30,60,90,120));
    private static final LocalTime minReservationTime = LocalTime.of(8,0);
    private static final LocalTime maxReservationTime = LocalTime.of(17,0);
    private LocalDateTime reservationDayAndTime;
    private LocalDateTime reservationEndTime;
    private int reservationDuration;
    private String reservationGroup;
    private String roomName;

    public LocalDateTime getReservationDayAndTime() {
        return reservationDayAndTime;
    }

    public LocalDateTime getReservationEndTime() {
        return reservationEndTime;
    }

    public String getReservationGroup() {
        return reservationGroup;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setReservationDayAndTime(LocalDateTime reservationDayAndTime) {
        this.reservationDayAndTime = reservationDayAndTime;
    }

    public void setReservationEndTime(LocalDateTime reservationEndTime) {
        this.reservationEndTime = reservationEndTime;
    }

    public void setReservationDuration(int reservationDuration) {
        this.reservationDuration = reservationDuration;
    }

    public void setReservationGroup(String group) {
        this.reservationGroup = group;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Reservation (){
        this.addReservationToSystem();
    }

    public Reservation (String groupName, LocalDateTime startTime, LocalDateTime endTime, int reservationDuration, String roomName) {
        this.reservationGroup = groupName;
        this.roomName = roomName;
        this.reservationDuration = reservationDuration;
        this.reservationDayAndTime = startTime;
        this.reservationEndTime = endTime;
        Room.addReservationToList(this);
    }

    public boolean isOverlapping(Reservation reservation) {
        return reservation.getReservationDayAndTime().isAfter(this.getReservationDayAndTime()) &&
                reservation.getReservationDayAndTime().isBefore(this.getReservationEndTime()) ||
                (this.getReservationDayAndTime().isAfter(reservation.getReservationDayAndTime()) &&
                        this.getReservationDayAndTime().isBefore(reservation.getReservationEndTime()));
    }

    private void addReservationToSystem(){  //One could consider making this smaller
        Scanner Input = new Scanner(System.in);
        System.out.println("What group?");
        setReservationGroup(Input.nextLine());
        if (reservationGroup == null) {
            System.out.println("Group does not exist");
            return;
        }
        System.out.println("What room?");
        setRoomName(Input.nextLine());
        if (Room.findRoom(roomName) == null) {
            System.out.println("Room does not exist");
            return;
        }
        System.out.println("What is the duration of the reservation, '30','60','90' or '120' minutes");
        setReservationDuration(Input.nextInt());
        if (!validDurations.contains(reservationDuration)){
            System.out.println("Invalid duration input");
            return;
        }
        System.out.println("What day would you like to book? (Year first, Month second, Day third, Hour fourth, Minute fifth");
        setReservationDayAndTime(LocalDateTime.of(Input.nextInt(),Input.nextInt(),Input.nextInt(),Input.nextInt(),Input.nextInt()));
        // There's gotta be a better way than this
        LocalDateTime today = LocalDateTime.now();
        if (reservationDayAndTime.isBefore(today)){
            System.out.println("Provided date is in the past");
            return;
        }
        if (today.plusDays(7).isBefore(reservationDayAndTime)) {
            System.out.println("Date too far into the future");
            return;
        }
        setReservationEndTime(reservationDayAndTime.plusMinutes(reservationDuration));

        if (reservationDayAndTime.toLocalTime().isBefore(minReservationTime) || reservationEndTime.toLocalTime().isAfter(maxReservationTime)){
            System.out.println("Invalid time stamp");
            return;
        }

        Group tempGroup = Group.findGroup(this.reservationGroup);
        ArrayList<Reservation> overlappingReservations = new ArrayList<>();
        // Consider handling a potential null here or something ;3
        for(Reservation res : Room.getRoomReservations()) {
            if (this.isOverlapping(res)) {
                overlappingReservations.add(res);
            }
        }
        if (overlappingReservations.isEmpty()) {
            Room.addReservationToList(this);
            tempGroup.setReservationPriority(tempGroup.getReservationPriority()+this.reservationDuration);
            System.out.println("The reservation has been completed");
        } else {
            for (Reservation res : overlappingReservations) {
                if (tempGroup.hasPriority(Group.findGroup(res.getReservationGroup()))) {
                    System.out.println("Time slot occupied");
                    return;
                }
            }
            for (Reservation res : overlappingReservations) {
                Room.getRoomReservations().remove(res); // potentially stop the find() and just do it once at the top
            }
            Room.addReservationToList(this);
            tempGroup.setReservationPriority(tempGroup.getReservationPriority()+this.reservationDuration);
            System.out.println("The reservation has been completed and less important groups have been yeeted from the system");
        }
    }
}
