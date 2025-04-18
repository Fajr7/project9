/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ggggh
 */
public class Client {
     private final int ID;
    private String name;
    private String phone;

    public Client(int ID, String name, String phone) {
        this.ID = ID;
        setName(name);
        setPhone(phone);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nName: %s\nPhone: %s", getID(), getName(), getPhone());
    }   
    
}
    

