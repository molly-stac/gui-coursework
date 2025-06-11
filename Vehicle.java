
package utms.Vehicles;

public abstract class Vehicle {
    private final String vehicleId;
    private final String make;
    final String model;
    private final int year;
    final String registrationNumber;

    public Vehicle(String vehicleId, String make, String model, int year, String registrationNumber) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleId() { return vehicleId; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getRegistrationNumber() { return registrationNumber; }

    public abstract void displayVehicleDetails();
}
    

