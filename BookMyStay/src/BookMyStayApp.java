public class BookMyStayApp {
    /**
     * UseCase1HotelBookingApp
     *
     * This class represents the entry point of the Hotel Booking Management System.
     * It demonstrates the basic structure of a Java application, including the
     * main() method and console output.
     *
     * The application prints a welcome message along with the system name and version.
     *
     * @author GURU
     * @version 1.0
     */


        /**
         * Main method - Entry point of the application
         *
         * @param args Command line arguments
         */
import java.util.HashMap;
import java.util.Map;

    /**
     * UseCase3InventorySetup
     *
     * This program demonstrates centralized room inventory management
     * using HashMap. It replaces scattered variables with a single
     * source of truth for room availability.
     *
     * @author GURU
     * @version 3.1
     */

// Inventory Class (Encapsulates all inventory logic)
    class RoomInventory {

        private Map<String, Integer> inventory;

        // Constructor to initialize inventory
        public RoomInventory() {
            inventory = new HashMap<>();

            // Initial room availability
            inventory.put("Single Room", 5);
            inventory.put("Double Room", 3);
            inventory.put("Suite Room", 2);
        }

        // Method to get availability of a room type
        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        // Method to update availability (controlled update)
        public void updateAvailability(String roomType, int count) {
            if (inventory.containsKey(roomType)) {
                inventory.put(roomType, count);
            } else {
                System.out.println("Room type not found!");
            }
        }

        // Method to display full inventory
        public void displayInventory() {
            System.out.println("------ Current Room Inventory ------");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    // Main Class
    public class UseCase3InventorySetup {

        public static void main(String[] args) {

            System.out.println("=====================================");
            System.out.println("   Book My Stay App - Version 3.1");
            System.out.println("=====================================\n");

            // Initialize inventory
            RoomInventory inventory = new RoomInventory();

            // Display initial inventory
            inventory.displayInventory();

            // Example: Update availability
            System.out.println("\nUpdating availability...\n");
            inventory.updateAvailability("Single Room", 4);

            // Display updated inventory
            inventory.displayInventory();

            System.out.println("\nApplication executed successfully.");
        }
    }
    }

