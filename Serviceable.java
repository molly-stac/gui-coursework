
package utms.Interfaces;


public interface Serviceable {

    void scheduleService(String date, String description);
    void performMaintenance(String maintenanceType);
    boolean needsService();

    public String getServiceStatus();

    public boolean isServiceDue();

    public void scheduleService(Date serviceDate, String monthly_Safety_Inspection);

    public void performMaintenance(String oil_Change, String changed_engine_oil_and_filter);
}

    

