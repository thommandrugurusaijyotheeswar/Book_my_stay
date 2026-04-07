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
        public static void main(String[] args) {

            System.out.println("=====================================");
            System.out.println("   Book My Stay App - Version 2.1");
            System.out.println("=====================================\n");

            // Creating room objects (Polymorphism)
            Room single = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suite = new SuiteRoom();

            // Static availability variables
            int singleAvailable = 5;
            int doubleAvailable = 3;
            int suiteAvailable = 2;

            // Display Single Room
            System.out.println("----- Single Room -----");
            single.displayDetails();
            System.out.println("Available: " + singleAvailable + "\n");

            // Display Double Room
            System.out.println("----- Double Room -----");
            doubleRoom.displayDetails();
            System.out.println("Available: " + doubleAvailable + "\n");

            // Display Suite Room
            System.out.println("----- Suite Room -----");
            suite.displayDetails();
            System.out.println("Available: " + suiteAvailable + "\n");

            System.out.println("Application executed successfully.");
        }
    }

