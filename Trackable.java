package utms.Interfaces;

    
public interface Trackable {
    String getCurrentLocation();
    void updateLocation(String newLocation);
    String getStatus();

    public String getGPSCoordinates();

    public String isTrackingEnabled();

    public String getLastKnownLocation();
}
    
