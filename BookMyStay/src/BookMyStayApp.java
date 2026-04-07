import java.util.*;

/**
 * UseCase6RoomAllocationService
 *
 * This program confirms booking requests and allocates rooms
 * while preventing double-booking using Set and HashMap.
 *
 * @author GURU
 * @version 6.0
 */

// Reservation Class
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Inventory Service
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void decrement(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

// Booking Service
class BookingService {

    private RoomInventory inventory;

    // Track allocated rooms (prevents duplicates)
    private Map<String, Set<String>> allocatedRooms = new HashMap<>();

    // Counter for unique IDs
    private int roomCounter = 1;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void processQueue(Queue<Reservation> queue) {

        while (!queue.isEmpty()) {

            Reservation req = queue.poll(); // FIFO
            String type = req.roomType;

            System.out.println("\nProcessing: " + req.guestName + " (" + type + ")");

            // Check availability
            if (inventory.getAvailability(type) > 0) {

                // Generate unique room ID
                String roomId = type.substring(0, 2).toUpperCase() + roomCounter++;

                // Initialize set if not present
                allocatedRooms.putIfAbsent(type, new HashSet<>());

                // Ensure uniqueness
                if (!allocatedRooms.get(type).contains(roomId)) {

                    allocatedRooms.get(type).add(roomId);

                    // Update inventory immediately
                    inventory.decrement(type);

                    System.out.println("Booking Confirmed!");
                    System.out.println("Guest: " + req.guestName);
                    System.out.println("Room ID: " + roomId);
                }

            } else {
                System.out.println("Booking Failed - No rooms available");
            }
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Book My Stay App - Version 6.0");
        System.out.println("=====================================");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Booking queue (FIFO)
        Queue<Reservation> queue = new LinkedList<>();

        queue.offer(new Reservation("Alice", "Single Room"));
        queue.offer(new Reservation("Bob", "Single Room"));
        queue.offer(new Reservation("Charlie", "Single Room")); // should fail

        queue.offer(new Reservation("David", "Double Room"));
        queue.offer(new Reservation("Eve", "Suite Room"));

        // Process bookings
        BookingService service = new BookingService(inventory);
        service.processQueue(queue);

        System.out.println("\nAll bookings processed.");
    }
}