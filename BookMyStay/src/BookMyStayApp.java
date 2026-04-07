import java.util.*;

/**
 * UseCase7AddOnServiceSelection
 *
 * This program demonstrates adding optional services
 * to an existing reservation without modifying booking logic.
 *
 * @author GURU
 * @version 7.0
 */

// Add-On Service Class
class AddOnService {
    private String name;
    private double cost;

    public AddOnService(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}

// Add-On Service Manager
class AddOnServiceManager {

    // Map: Reservation ID -> List of Services
    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    // Add service to a reservation
    public void addService(String reservationId, AddOnService service) {
        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added service: " + service.getName() +
                " to Reservation ID: " + reservationId);
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {
        System.out.println("\nServices for Reservation ID: " + reservationId);

        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        for (AddOnService s : services) {
            System.out.println("- " + s.getName() + " : ₹" + s.getCost());
        }
    }

    // Calculate total service cost
    public double calculateTotalCost(String reservationId) {
        List<AddOnService> services = serviceMap.get(reservationId);

        double total = 0;
        if (services != null) {
            for (AddOnService s : services) {
                total += s.getCost();
            }
        }
        return total;
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Book My Stay App - Version 7.0");
        System.out.println("=====================================");

        // Assume reservation IDs from Use Case 6
        String reservation1 = "SI1";
        String reservation2 = "DO1";

        AddOnServiceManager manager = new AddOnServiceManager();

        // Add services
        manager.addService(reservation1, new AddOnService("Breakfast", 300));
        manager.addService(reservation1, new AddOnService("Airport Pickup", 800));

        manager.addService(reservation2, new AddOnService("Extra Bed", 500));

        // Display services
        manager.displayServices(reservation1);
        manager.displayServices(reservation2);

        // Show total cost
        System.out.println("\nTotal Add-On Cost for " + reservation1 +
                " : ₹" + manager.calculateTotalCost(reservation1));

        System.out.println("\nTotal Add-On Cost for " + reservation2 +
                " : ₹" + manager.calculateTotalCost(reservation2));

        System.out.println("\nAdd-on services processed successfully.");
    }
}