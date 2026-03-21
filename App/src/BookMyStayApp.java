import java.util.*;

/*
======================================================
Commit 1: Initial Room Class
Author: D SAI SRI HARSHIT
Description:
Created Room class to store room attributes
like beds, size and price.
======================================================
*/

class Room {

    private int beds;
    private int size;
    private double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}

/*
======================================================
Commit 2: RoomInventory Implementation
Author: Developer
Description:
Added RoomInventory class to store
availability of different room types.
======================================================
*/

class RoomInventory {

    private Map<String, Integer> availability = new HashMap<>();

    public RoomInventory() {

        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);

    }

    public Map<String, Integer> getRoomAvailability() {
        return availability;
    }
}

/*
======================================================
Commit 3: RoomSearchService
Author: D SAI SRI HARSHIT
Description:
Implemented read-only search functionality
to display available rooms and their details.
No booking or inventory modification happens here.
======================================================
*/

class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability =
                inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        // Single Room
        if (availability.get("Single") > 0) {

            System.out.println("Single Room:");
            System.out.println("Beds: " + singleRoom.getBeds());
            System.out.println("Size: " + singleRoom.getSize() + " sqft");
            System.out.println("Price per night: " + singleRoom.getPrice());
            System.out.println("Available: " + availability.get("Single"));
            System.out.println();
        }

        // Double Room
        if (availability.get("Double") > 0) {

            System.out.println("Double Room:");
            System.out.println("Beds: " + doubleRoom.getBeds());
            System.out.println("Size: " + doubleRoom.getSize() + " sqft");
            System.out.println("Price per night: " + doubleRoom.getPrice());
            System.out.println("Available: " + availability.get("Double"));
            System.out.println();
        }

        // Suite Room
        if (availability.get("Suite") > 0) {

            System.out.println("Suite Room:");
            System.out.println("Beds: " + suiteRoom.getBeds());
            System.out.println("Size: " + suiteRoom.getSize() + " sqft");
            System.out.println("Price per night: " + suiteRoom.getPrice());
            System.out.println("Available: " + availability.get("Suite"));
        }
    }
}

/*
======================================================
Commit 4: Main Application
Author: D SAI SRI HARSHIT
Description:
Added main class to demonstrate
Room Search & Availability Check use case.
======================================================
*/

public class BookMyStayApp {

    public static void main(String[] args) {

        Room singleRoom = new Room(1, 250, 1500.0);
        Room doubleRoom = new Room(2, 400, 2500.0);
        Room suiteRoom = new Room(3, 750, 5000.0);

        RoomInventory inventory = new RoomInventory();

        RoomSearchService service = new RoomSearchService();

        service.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}