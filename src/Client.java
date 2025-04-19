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
    private PayingOff payingOff;

    public Client(int ID, String name, String phone, String paymentType, int cardID) {
        this.ID = ID;
        setName(name);
        setPhone(phone);
        DeterminePayment(paymentType, cardID);
    }
    
    public void DeterminePayment(String paymentType,int cardID){
    if (paymentType.equalsIgnoreCase("cash")) {
            payingOff = new Cash();
        } else if (paymentType.equalsIgnoreCase("card")) {
            payingOff = new Card(cardID);
        } else {
            System.out.println("Invalid payment type. Defaulting to cash.");
            payingOff = new Cash();
        }
        
    }
      public int getCardID() {
        if (payingOff instanceof Card) {
            return ((Card) payingOff).getIDcard();
        }
        return 0;
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
    return String.format("Id: %d\nName: %s\nPhone: %s\nPayment Type: %s", getID(), getName(), getPhone(), (payingOff instanceof Card) ? "Card" : "Cash");
   }
    
}
    

