package newpackage1; 
 
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template 
 */ 
 
/** 
 * 
 * @author ggggh 
 */ 
public class Feedback { 
private String comment; 
    private int rating; 
    private Service servise; 
 
    public Feedback() { 
        this("", 0 , null); 
    } 
 
    public Feedback(String comment, int rating, Service servise) { 
        this.comment = comment; 
        this.rating = rating; 
        this.servise = servise; 
    } 
 
    public String getComment() { 
        return comment; 
    } 
 
    public void setComment(String comment) { 
        this.comment = comment; 
    } 
 
    public int getRating() { 
        return rating; 
    } 
 
    public void setRating(int rating) { 
        this.rating = rating; 
    } 
 
    public Service getServise() { 
        return servise; 
    } 
 
    public void setServise(Service servise) { 
        this.servise = servise; 
    } 
     
    @Override 
    public String toString() { 
        return String.format("Comment: %d\nRating: %d\nServise", getComment(), getRating(), getServise() ); 
} 
}