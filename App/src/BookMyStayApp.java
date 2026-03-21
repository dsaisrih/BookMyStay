/**
 * Author: D SAI SRI HARSHIT
 * Use Case 10: Booking Cancellation & Inventory Rollback
 */

import java.io.*;
import java.util.*;

// Room Inventory
class RoomInventory {
    private Map<String, Integer> rooms;

    public RoomInventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public void bookRoom(String roomType) {
        rooms.put(roomType, rooms.get(roomType) - 1);
    }

    public void releaseRoom(String roomType) {
        rooms.put(roomType, rooms.get(roomType) + 1);
    }

    public int getAvailability(String roomType) {
        return rooms.get(roomType);
    }
}

// Cancellation Service
class CancellationService {

    // Map: reservationId -> roomType
    private Map<String, String> reservationRoomTypeMap;

    // Stack for rollback history (LIFO)
    private Stack<String> rollbackStack;

    public CancellationService() {
        reservationRoomTypeMap = new HashMap<>();
        rollbackStack = new Stack<>();
    }

    // Register booking
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    // Cancel booking
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation. Reservation not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Restore inventory
        inventory.releaseRoom(roomType);

        // Push to rollback stack
        rollbackStack.push(reservationId);

        // Remove booking
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    // Show rollback history
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");

        if (rollbackStack.isEmpty()) {
            System.out.println("No cancellations yet.");
            return;
        }

        for (int i = rollbackStack.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + rollbackStack.get(i));
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation\n");

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        // Simulate booking
        String reservationId = "Single-1";
        service.registerBooking(reservationId, "Single");
        inventory.bookRoom("Single");

        // Cancel booking
        service.cancelBooking(reservationId, inventory);

        // Show rollback history
        service.showRollbackHistory();

        // Show updated inventory
        System.out.println("\nUpdated Single Room Availability: " +
                inventory.getAvailability("Single"));
    }
}