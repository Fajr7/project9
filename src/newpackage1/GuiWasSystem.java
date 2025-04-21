package newpackage1; 
 
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template 
 */ 
 
import java.util.ArrayList; 
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.TextArea; 
import javafx.scene.layout.Background; 
import javafx.scene.layout.BackgroundFill; 
import javafx.scene.layout.GridPane; 
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.stage.Stage; 
 
public class GuiWashSystem  extends Application { 
  @Override 
    public void start(Stage stage) { 
 
        GridPane grid = new GridPane(); 
        grid.setAlignment(Pos.CENTER); 
        grid.setHgap(10); 
        grid.setVgap(10); 
        grid.setPadding(new Insets(30)); 
 
        Text welcomeMsg = new Text("  Welcome TO Wash System     "); 
        welcomeMsg.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 16)); 
 
        grid.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null))); 
        welcomeMsg.setFill(Color.CADETBLUE); 
 
        grid.add(welcomeMsg, 0, 0, 2, 1); 
 
        TextArea tArea = new TextArea(); 
        tArea.setEditable(false); 
 
        grid.add(tArea, 0, 1, 2, 2); 
 
        Button btn = new Button("Display  Services"); 
        btn.setTextFill(Color.BLACK); 
        btn.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null))); 
        btn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override 
            public void handle(ActionEvent event) { 
 
                ArrayList<Service> services = Main.services; 
                String s = ""; 
                for (Service c : services) { 
                    s += c + "\n=========================\n"; 
                } 
                tArea.setText(s); 
            } 
 
        }); 
 
        grid.add(btn, 1, 3); 
 
        Scene scene = new Scene(grid, 400, 300); 
 
        stage.setScene(scene); 
        stage.setTitle("wash System"); 
        stage.show(); 
        stage.setResizable(false); 
 
    } 
 
    public static void main(String[] args) { 
        launch(args); 
    } 
}