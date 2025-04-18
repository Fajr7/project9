/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ggggh
 */
public abstract  class Service {
 private final int ID;
    private String name;
    private double price;
    private ScheduleEntry[] schedulEntry;
    private static int count;

    public Service() {
        this(0, "", 0.0, null);
    }

    public Service(int ID, String name, double price, ScheduleEntry[] schedulEntry) {
        this.ID = ID;
        setName(name);
        setPrice(price);
        setSchedulEntry(schedulEntry);
        count++;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            this.price = 0;
            System.out.println("invalid price!");
        }
    }

    public ScheduleEntry[] getSchedulEntry() {
        return schedulEntry;
    }

    public void setSchedulEntry(ScheduleEntry[] schedulEntry ) {
        this.schedulEntry = schedulEntry ;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Service.count = count;
    }

    //abstract method
    public abstract double calcPrice();
    

    public final void displaySchedulEntry() {
        if (schedulEntry  == null) {
            System.out.println("All schedul Entry  have been booked!");
        } else {
            System.out.println("*** Available schedul entry  ***");
            for (int i = 0; i < schedulEntry .length; i++) {
                if (schedulEntry [i] != null) {
                    System.out.println("Index: " + i);
                    System.out.println(schedulEntry [i]);
                    System.out.println("-------------------------------------");

                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nName: %s\nPrice: %.2f SAR", getID(), getName(), getPrice());
    }
}
