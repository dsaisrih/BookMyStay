/**
 * ============================================================
 * ABSTRACT CLASS - Room
 * ============================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This abstract class represents a generic hotel room.
 * It models attributes that are intrinsic to a room type
 * and remain constant regardless of availability.
 *
 * Inventory-related concerns are intentionally excluded.
 * @author D SAI SRI HARSHIT
 * @version 2.1
 */

abstract class Room {

    /** Number of beds available in the room. */
    protected int numberOfBeds;

    /** Total size of the room in square feet. */
    protected int squareFeet;

    /** Price charged per night for this room type. */
    protected double pricePerNight;

    /**
     * Constructor used by child classes to
     * initialize common room attributes.
     *
     * @param numberOfBeds number of beds in the room
     * @param squareFeet total room size
     * @param pricePerNight cost per night
     */
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Displays room details.
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
 * @author D SAI SRI HARSHIT
 * @version 2.1
 */
class SingleRoom extends Room {

    /**
     * Initializes a SingleRoom with
     * predefined attributes.
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
 * @author D SAI SRI HARSHIT
 * @version 2.1
 */
class DoubleRoom extends Room {

    /**
     * Initializes a DoubleRoom with
     * predefined attributes.
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
 * @author D SAI SRI HARSHIT
 * @version 2.1
 */
class SuiteRoom extends Room {

    /**
     * Initializes a SuiteRoom with
     * predefined attributes.
     */
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}


/**
 * ============================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * ============================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class demonstrates room initialization
 * using domain models before introducing
 * centralized inventory management.
 *
 * Availability is represented using simple
 * variables to highlight limitations.
 * @author D SAI SRI HARSHIT
 * @version 2.1
 */


public class BookMyStayApp {

    /**
     * Application entry point.
     *
     * This method is the first method executed
     * when the program is launched by the JVM.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Creating room objects
        SingleRoom singleRoom = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suiteRoom = new SuiteRoom();

        // Static availability values
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display Single Room details
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        // Display Double Room details
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        // Display Suite Room details
        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
        System.out.println("Welcome to the Hotel Booking Management System");
        System.out.println("System initialized successfully.");

    }
}