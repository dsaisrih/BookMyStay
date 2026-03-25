import java.util.*;

/**
 * Author - D Sai Sri Harshit
 *UseCase7- AddOnServiceSelection
 * CLASS - AddOnService
 * Represents an optional service.
 */
class AddOnService {

    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}

/**
 * CLASS - AddOnServiceManager
 * Manages services for reservations.
 */
public class AddOnServiceManager {

    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service) {
        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        double total = 0.0;

        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (AddOnService service : services) {
                total += service.getCost();
            }
        }

        return total;
    }

    // Sample main method (for testing)
    public static void main(String[] args) {
        AddOnServiceManager manager = new AddOnServiceManager();

        manager.addService("R1", new AddOnService("Breakfast", 500));
        manager.addService("R1", new AddOnService("Spa", 1500));
        manager.addService("R1", new AddOnService("Airport Pickup", 800));

        double total = manager.calculateTotalServiceCost("R1");

        System.out.println("Total Cost: " + total);
    }
}
