import java.util.LinkedList;
import java.util.Queue;

/**
 * UseCase5BookingRequestQueue
 *
 * This program demonstrates booking request handling using
 * a Queue (FIFO) to ensure fairness.
 *
 * No inventory updates are performed here.
 *
 * @author GURU
 * @version 5.0
 */

// Reservation Class (represents booking request)
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

    public void display() {
        System.out.println("Guest: " + guestName + ", Room Type: " + roomType);
    }
}

// Booking Queue Class
class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added: ");
        reservation.display();
    }

    // View all requests (without removing)
    public void displayQueue() {
        System.out.println("\n------ Booking Request Queue ------");
        for (Reservation r : queue) {
            r.display();
        }
    }

    // Get next request (for future processing)
    public Reservation getNextRequest() {
        return queue.peek(); // does not remove
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Book My Stay App - Version 5.0");
        System.out.println("=====================================\n");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulate booking requests
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));

        // Display queue
        bookingQueue.displayQueue();

        // Show next request (FIFO)
        System.out.println("\nNext request to process:");
        Reservation next = bookingQueue.getNextRequest();
        if (next != null) {
            next.display();
        }

        System.out.println("\nAll requests stored in FIFO order.");
        System.out.println("No booking processed yet (no inventory change).");
    }
}