package newpackage1;

 
import java.io.FileNotFoundException; 
import java.util.Formatter; 
import java.util.FormatterClosedException; 
 
public class WriteText { 
 
    private Formatter output; 
 
    public void openTextFile(String fileName) { 
        try { 
            output = new Formatter(fileName); 
        } catch (SecurityException ex) { 
            System.err.println("You do not have write access to this file."); 
            System.err.println(ex); 
        } catch (FileNotFoundException ex) { 
            System.err.println("Error opening or creating file."); 
            System.err.println(ex); 
        } 
    } 
 
    public void writeToFile(Service s) { 
 
        try { 
            output.format(s.toString() + "\n"); 
            output.format("\n---------------------------------------------\n"); 
        } catch (FormatterClosedException ex) { 
            System.err.println("Error writing to file"); 
            System.err.println(ex); 
        } 
    } 
 
    public void closeFile() { 
        if (output != null) { 
            output.close(); 
        } 
    } 
}