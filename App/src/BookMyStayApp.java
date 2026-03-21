import java.util.*;

/*
=====================================================
Commit 1: Create Reservation Class
Author: D SAI SRI HARSHIT
Description:
Created Reservation class to store
guest booking request details.
=====================================================
*/

class Reservation {

    // Name of guest
    private String guestName;

    // Requested room type
    private String roomType;

    // Constructor
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    // Getter for guest name
    public String getGuestName() {
        return guestName;
    }

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }
}


/*
=====================================================
Commit 2: Implement BookingRequestQueue
Author: D SAI SRI HARSHIT
Description:
Added queue-based structure to manage
incoming booking requests using FIFO.
=====================================================
*/

class BookingRequestQueue {

    // Queue storing booking requests
    private Queue<Reservation> requestQueue;

    // Constructor
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add request to queue
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    // Get next request
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Check if requests exist
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}


/*
=====================================================
Commit 3: Create Main Application
Author: D SAI SRI HARSHIT
Description:
Added BookMyStayApp main class to
simulate booking request processing
using queue (FIFO order).
=====================================================
*/

public class BookMyStayApp {

    public static void main(String[] args) {

        // Display heading
        System.out.println("Booking Request Queue\n");

        // Initialize queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {

            Reservation request = bookingQueue.getNextRequest();

            System.out.println("Processing Booking Request:");
            System.out.println("Guest Name: " + request.getGuestName());
            System.out.println("Room Type: " + request.getRoomType());
            System.out.println();
        }
    }
}