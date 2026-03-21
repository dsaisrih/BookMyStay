import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * ABSTRACT CLASS - Room
 * ============================================================
 *
 * Represents a generic hotel room.
 * @author - D SAI SRI HARSHIT
 * @version 3.0
 */

abstract class Room {

    /** Number of beds available in the room */
    protected int numberOfBeds;

    /** Total size of the room in square feet */
    protected int squareFeet;

    /** Price charged per night for this room type */
    protected double pricePerNight;

    /**
     * Constructor initializes common room attributes
     *
     * @param numberOfBeds number of beds
     * @param squareFeet room size
     * @param pricePerNight price per night
     */
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Displays room details
     */
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}


/**
 * ============================================================
 * CLASS - SingleRoom
 * ============================================================
 *
 * Represents a single room in the hotel.
 * @author - D SAI SRI HARSHIT
 * @version 3.0
 */

class SingleRoom extends Room {

    /**
     * Initializes a SingleRoom with predefined attributes
     */
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}


/**
 * ============================================================
 * CLASS - DoubleRoom
 * ============================================================
 *
 * Represents a double room in the hotel.
 *
 * @author - D SAI SRI HARSHIT
 *  @version 3.0
 */

class DoubleRoom extends Room {

    /**
     * Initializes a DoubleRoom with predefined attributes
     */
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}


/**
 * ============================================================
 * CLASS - SuiteRoom
 * ============================================================
 *
 * Represents a suite room in the hotel.
 * @author - D SAI SRI HARSHIT
 * @version 3.0
 */

class SuiteRoom extends Room {

    /**
     * Initializes a SuiteRoom with predefined attributes
     */
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}


/**
 * ============================================================
 * CLASS - RoomInventory
 * ============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class acts as the single source of truth
 * for room availability in the hotel.
 *
 * Room pricing and characteristics are obtained
 * from Room objects, not duplicated here.
 *
 *  @author - D SAI SRI HARSHIT
 * @version 3.0
 */

class RoomInventory {

    /**
     * Stores available room count for each room type.
     *
     * Key   -> Room type name
     * Value -> Available room count
     */
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes the inventory
     * with default availability values
     */
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /**
     * Initializes room availability data
     */
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Returns the current availability map
     *
     * @return map of room type to available count
     */
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    /**
     * Updates availability for a specific room type
     *
     * @param roomType the room type
     * @param count new room count
     */
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}


/**
 * ============================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * Demonstrates how room availability is managed
 * using a centralized inventory.
 *
 * Room objects are used to retrieve pricing
 * and room characteristics.
 *
 * @author - D SAI SRI HARSHIT
 * @version 3.1
 */

public class BookMyStayApp {

    /**
     * Application entry point
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        SingleRoom single = new SingleRoom();
        DoubleRoom doub = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        // Display Single Room
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: "
                + inventory.getRoomAvailability().get("Single") + "\n");

        // Display Double Room
        System.out.println("Double Room:");
        doub.displayRoomDetails();
        System.out.println("Available Rooms: "
                + inventory.getRoomAvailability().get("Double") + "\n");

        // Display Suite Room
        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: "
                + inventory.getRoomAvailability().get("Suite"));
    }
}