import java.util.ArrayList;
import java.util.List;

public class RidelaneBackend {
    public static class Driver {
        private String name;
        private String phone;
        private String vehicle;
        private String plate;
        private int seats;
        private String route;
        private double pricePerSeat;

        public Driver(String name, String phone, String vehicle, String plate, int seats, String route, double pricePerSeat) {
            this.name = name;
            this.phone = phone;
            this.vehicle = vehicle;
            this.plate = plate;
            this.seats = seats;
            this.route = route;
            this.pricePerSeat = pricePerSeat;
        }

        public String getName() { return name; }
        public String getPhone() { return phone; }
        public String getVehicle() { return vehicle; }
        public String getPlate() { return plate; }
        public int getSeats() { return seats; }
        public String getRoute() { return route; }
        public double getPricePerSeat() { return pricePerSeat; }
    }

    public static class Passenger {
        private String name;
        private String phone;
        private int seatsNeeded;

        public Passenger(String name, String phone, int seatsNeeded) {
            this.name = name;
            this.phone = phone;
            this.seatsNeeded = seatsNeeded;
        }

        public String getName() { return name; }
        public String getPhone() { return phone; }
        public int getSeatsNeeded() { return seatsNeeded; }
    }

    public static class Booking {
        private Passenger passenger;
        private Driver driver;
        private String pickupLocation;
        private String date;

        public Booking(Passenger passenger, Driver driver, String pickupLocation, String date) {
            this.passenger = passenger;
            this.driver = driver;
            this.pickupLocation = pickupLocation;
            this.date = date;
        }

        public Passenger getPassenger() { return passenger; }
        public Driver getDriver() { return driver; }
        public String getPickupLocation() { return pickupLocation; }
        public String getDate() { return date; }
    }

    public static class TransportService {
        private final List<Driver> drivers = new ArrayList<>();
        private final List<Booking> bookings = new ArrayList<>();

        public void addDriver(Driver driver) {
            drivers.add(driver);
        }

        public List<Driver> getDrivers() {
            return drivers;
        }

        public void createBooking(Passenger passenger, Driver driver, String pickupLocation, String date) {
            bookings.add(new Booking(passenger, driver, pickupLocation, date));
        }

        public List<Booking> getBookings() {
            return bookings;
        }
    }

    public static void main(String[] args) {
        Driver driver1 = new Driver(
                "Sipho Ndlovu",
                "0821234567",
                "Toyota Quantum",
                "CA 198 765",
                12,
                "Claremont to Sunridge Primary",
                850.00
        );

        Passenger passenger1 = new Passenger("Aisha Khan", "0719981122", 2);

        TransportService service = new TransportService();
        service.addDriver(driver1);
        service.createBooking(passenger1, driver1, "Claremont Station", "2026-11-12");

        System.out.println("Available drivers: " + service.getDrivers().size());
        System.out.println("Active bookings: " + service.getBookings().size());
        System.out.println("Driver route: " + service.getDrivers().get(0).getRoute());
    }
}
