package newpackage1; 
 
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template 
 */ 
 
public class Card extends PayingOff{ 
private int IDcard; 
 
    public Card(int IDcard){ 
        this.IDcard = IDcard; 
    } 
 
    public int getIDcard() { 
        return IDcard; 
    } 
 
    public void setIDcard(int IDcard) { 
        this.IDcard = IDcard; 
    } 
@Override 
public void ConversionSucess(){ 
    System.out.println("Payment completed using card");    
} 
     
     
}