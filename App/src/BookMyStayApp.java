import java.util.*;

/*
=====================================================
Commit 1: Create Reservation Class
Author: D SAI SRI HARSHIT
Description:
Created Reservation class to store
guest name and requested room type.
=====================================================
*/

class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}


/*
=====================================================
Commit 2: Implement RoomInventory
Author: D SAI SRI HARSHIT
Description:
Added RoomInventory class to maintain
room availability for different room types.
=====================================================
*/

class RoomInventory {

    private Map<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();

        availability.put("Single", 2);
        availability.put("Double", 1);
        availability.put("Suite", 1);
    }

    public int getAvailableRooms(String type) {
        return availability.getOrDefault(type, 0);
    }

    public void decrementRoom(String type) {
        availability.put(type, availability.get(type) - 1);
    }
}


/*
=====================================================
Commit 3: Implement RoomAllocationService
Author: D SAI SRI HARSHIT
Description:
Created service to allocate rooms to guests.
Ensures unique room IDs and tracks allocated rooms.
=====================================================
*/

class RoomAllocationService {

    // Set ensures unique room IDs
    private Set<String> allocatedRoomIds;

    // Map to store allocated room IDs by type
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {

        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    // Allocate room for reservation
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        if (inventory.getAvailableRooms(roomType) <= 0) {

            System.out.println("No rooms available for " + roomType);
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.decrementRoom(roomType);

        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: "
                + roomId);
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        return roomType + "-" + count;
    }
}


/*
=====================================================
Commit 4: Create Main Application
Author: D SAI SRI HARSHIT
Description:
Added main class to demonstrate
Room Allocation processing.
=====================================================
*/

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        RoomInventory inventory = new RoomInventory();

        RoomAllocationService service = new RoomAllocationService();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        service.allocateRoom(r1, inventory);
        service.allocateRoom(r2, inventory);
        service.allocateRoom(r3, inventory);
    }
}