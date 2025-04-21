package newpackage1; 
 
import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.Background; 
import javafx.scene.layout.BackgroundFill; 
import javafx.scene.layout.GridPane; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage; 
 
public class GUI extends Application { 
 
    @Override 
    public void start(Stage primaryStage) { 
 
        GridPane grid = new GridPane(); 
        grid.setVgap(10); 
        grid.setHgap(10); 
        grid.setPadding(new Insets(20)); 
        grid.setBackground(new Background(new BackgroundFill(Color.AZURE, null, null))); 
 
        Label chemicalLabel = new Label("Chemical:"); 
        TextField chemicalField = new TextField(); 
 
        Label idLabel = new Label("ID:"); 
        TextField idField = new TextField(); 
 
        Label nameLabel = new Label("Name:"); 
        TextField nameField = new TextField(); 
 
        Label priceLabel = new Label("Price:"); 
        TextField priceField = new TextField(); 
 
        Label scheduleYearLabel = new Label("Year:"); 
        TextField scheduleYearField = new TextField(); 
 
        Label scheduleMonthLabel = new Label("Month:"); 
        TextField scheduleMonthField = new TextField(); 
 
        Label scheduleHourLabel = new Label("Hour:"); 
        TextField scheduleHourField = new TextField(); 
 
        Label scheduleMinuteLabel = new Label("Minute:"); 
        TextField scheduleMinuteField = new TextField(); 
 
        Label scheduleAvailableLabel = new Label("Available (true/false):"); 
        TextField scheduleAvailableField = new TextField(); 
 
        Button addButton = new Button("Add Polish"); 
        addButton.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null))); 
        TextArea outputArea = new TextArea(); 
        outputArea.setEditable(false); 
        outputArea.setPrefHeight(200); 
 
        grid.add(chemicalLabel, 0, 0); 
        grid.add(chemicalField, 1, 0); 
 
        grid.add(idLabel, 0, 1); 
        grid.add(idField, 1, 1); 
 
        grid.add(nameLabel, 0, 2); 
        grid.add(nameField, 1, 2); 
 
        grid.add(priceLabel, 0, 3); 
        grid.add(priceField, 1, 3); 
 
        grid.add(scheduleYearLabel, 0, 4); 
        grid.add(scheduleYearField, 1, 4); 
 
        grid.add(scheduleMonthLabel, 0, 5); 
        grid.add(scheduleMonthField, 1, 5); 
 
        grid.add(scheduleHourLabel, 0, 7); 
        grid.add(scheduleHourField, 1, 7); 
 
        grid.add(scheduleMinuteLabel, 0, 8); 
        grid.add(scheduleMinuteField, 1, 8); 
 
        grid.add(scheduleAvailableLabel, 0, 9); 
        grid.add(scheduleAvailableField, 1, 9); 
 
        grid.add(addButton, 1, 10); 
        grid.add(outputArea, 0, 11, 2, 1); 
 
        addButton.setOnAction(e -> { 
            try { 
 
                String chemical = chemicalField.getText(); 
                int id = Integer.parseInt(idField.getText()); 
                String name = nameField.getText(); 
                double price = Double.parseDouble(priceField.getText()); 
 
                int year = Integer.parseInt(scheduleYearField.getText()); 
                int month = Integer.parseInt(scheduleMonthField.getText()); 
 
                int hour = Integer.parseInt(scheduleHourField.getText()); 
                int minute = Integer.parseInt(scheduleMinuteField.getText()); 
                boolean available = Boolean.parseBoolean(scheduleAvailableField.getText()); 
 
                LocalDateTime dateTime = new LocalDateTime(year, month, hour, minute); 
 
                ScheduleEntry scheduleEntry = new ScheduleEntry(1, dateTime, available); 
 
                ScheduleEntry[] scheduleEntries = {scheduleEntry}; 
                Polish polish = new Polish(chemical, id, name, price, scheduleEntries); 
 
                outputArea.setText(polish.toString()); 
 
                Main.services.add(polish); 
                 
                 
                System.out.println("The Polish has been added successfully.");
                } catch (Exception ex) { 
                outputArea.setText("Error: " + ex.getMessage()); 
            } 
        }); 
 
        Scene scene = new Scene(grid, 600, 600); 
        primaryStage.setTitle("Polish"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    } 
 
    public static void main(String[] args) { 
        launch(args); 
    } 
}