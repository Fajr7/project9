/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ggggh
 */
public class Booking {
   
   private final int ID;
    private Client client;
    private String status;
    private Service service;
    private ScheduleEntry schedulEntry;
    private static int count;

    public Booking() {
    this(null,null,null);
    }

    public Booking(Client client, Service service, ScheduleEntry schedulEntry) {
        ID= (int)((100)*Math.random()+1);
        this.client = client;
        this.service = service;
        this.schedulEntry = schedulEntry;
    }

    public int getID() {
        return ID;
    }

    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ScheduleEntry getSchedulEntry() {
        return schedulEntry;
    }

    public void setSchedulEntry(ScheduleEntry schedulEntry) {
        this.schedulEntry = schedulEntry;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Booking.count = count;
    }

    @Override
    public String toString() {
        return String.format( "ID: %d\nService: %s\nSchedulEntry: %s\nClient: %s\nstatus: %s",getID(),getService(),getSchedulEntry(), getClient(),getStatus());
    }
   

   
    
}

