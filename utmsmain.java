
package utms.main;

import java.util.Date;
import java.util.Calendar;
import utms.Interfaces.Serviceable;
import utms.Interfaces.Trackable;
import utms.Vehicles.Bus;
import utms.Vehicles.Van;

/**
 * Demo class to test the University Transport Management System
 * Demonstrates interface implementation and polymorphism
 */
public class utmsmain {
    
    public static void main(String[] args) {
        System.out.println("=== University Transport Management System Demo ===\n");
        
        // Create Bus and Van objects
        Bus universityBus = new Bus("UB001", 50, "UAM-001");
        Van universityVan = new Van("UV001", 12, "UAM-002");
        
        System.out.println("1. VEHICLE INFORMATION");
        System.out.println("----------------------");
        System.out.println("Bus Information:");
        universityBus.displayInfo();
        
        System.out.println("\nVan Information:");
        universityVan.displayInfo();
        
        System.out.println("\n2. STARTING ENGINES");
        System.out.println("-------------------");
        universityBus.startEngine();
        universityVan.startEngine();
        
        System.out.println("\n3. TRACKING FUNCTIONALITY");
        System.out.println("-------------------------");
        
        // Demonstrate polymorphism - treating objects as Trackable
        Trackable[] trackableVehicles = {universityBus, universityVan};
        
        for (Trackable vehicle : trackableVehicles) {
            System.out.println("Current location: " + vehicle.getCurrentLocation());
            System.out.println("GPS Coordinates: " + vehicle.getGPSCoordinates());
            System.out.println("Tracking enabled: " + vehicle.isTrackingEnabled());
            
            // Update location
            if (vehicle instanceof Bus) {
                vehicle.updateLocation("Main Campus Gate");
            } else if (vehicle instanceof Van) {
                vehicle.updateLocation("Science Block");
            }
            
            System.out.println("New location: " + vehicle.getCurrentLocation());
            System.out.println("Last known location: " + vehicle.getLastKnownLocation());
            System.out.println();
        }
        
        System.out.println("4. SERVICE FUNCTIONALITY");
        System.out.println("------------------------");
        
        // Demonstrate polymorphism - treating objects as Serviceable
        Serviceable[] serviceableVehicles = {universityBus, universityVan};
        
        // Schedule services
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30); // 30 days from now
        Date serviceDate = cal.getTime();
        
        for (Serviceable vehicle : serviceableVehicles) {
            System.out.println("Service Status: " + vehicle.getServiceStatus());
            System.out.println("Service Due: " + (vehicle.isServiceDue() ? "Yes" : "No"));
            
            if (vehicle instanceof Bus) {
                vehicle.scheduleService(serviceDate, "Monthly Safety Inspection");
                vehicle.performMaintenance("Oil Change", "Changed engine oil and filter");
            } else if (vehicle instanceof Van) {
                vehicle.scheduleService(serviceDate, "Brake System Check");
                vehicle.performMaintenance("Tire Rotation", "Rotated all four tires for even wear");
            }
            
            System.out.println("Updated Service Status: " + vehicle.getServiceStatus());
            System.out.println();
        }
        
        System.out.println("5. MAINTENANCE HISTORY");
        System.out.println("----------------------");
        System.out.println("Bus Maintenance History:");
        System.out.println(universityBus.getMaintenanceHistory());
        
        System.out.println("Van Maintenance History:");
        System.out.println(universityVan.getMaintenanceHistory());
        
        System.out.println("6. ADVANCED FEATURES");
        System.out.println("--------------------");
        
        // Van-specific operations
        universityVan.setCargoType("Laboratory Equipment");
        universityVan.updateLocation("Chemistry Lab");
        universityVan.updateLocation("Physics Lab");
        
        System.out.println("Van Mileage: " + universityVan.getMileage() + " km");
        System.out.println("Van Cargo Type: " + universityVan.getCargoType());
        
        // Test tracking disable/enable
        System.out.println("\n7. TRACKING CONTROL");
        System.out.println("-------------------");
        universityBus.setTrackingEnabled(false);
        universityVan.setTrackingEnabled(false);
        
        System.out.println("Bus tracking enabled: " + universityBus.isTrackingEnabled());
        System.out.println("Van tracking enabled: " + universityVan.isTrackingEnabled());
        
        // Re-enable tracking
        universityBus.setTrackingEnabled(true);
        universityVan.setTrackingEnabled(true);
        
        System.out.println("\n=== Demo Complete ===");
    }
}
