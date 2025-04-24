package newpackage1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    public static ArrayList<Service> services = new ArrayList<Service>();
    //(Client client, Service service, ScheduleEntry schedulEntry)
    static Booking B1 = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        fillList(services);

        LocalDateTime T = new LocalDateTime(2025, 4, 23, 25);
        int serviceID;
        String service;
        System.out.println("-------Welcome To Car Wash Booking System!-------");
        System.out.println("Select one of the following options to continue:");

        int choice = 0;
        Booking booking = null;
        do {
            try {
                menu();
                choice = input.nextInt();//Name Object of Scanner
                switch (choice) {

                    case 1://show all services

                        boolean flag = true;
                        System.out.println("***All services***");
                        for (Service S : services) {
                            System.out.println(S);//toString
                            S.displaySchedulEntry();

                            if (S instanceof Polish) {
                                System.out.println(((Polish) S).describeService());
                            }
                            System.out.println("-------------------------------------");
                        }
                        break;

                    case 2:// Show Wash Services

                        System.out.println("*** Wash Services ***");
                        for (Service Listservice : services) {// Name of ArrayList
                            if (Listservice instanceof Wash) {
                                System.out.println(Listservice);
                                System.out.println("-------------------------------------");
                            }
                        }
                        break;

                    case 3: // Remove service
                        System.out.print("Enter the ID of the service you want to remove: ");
                        int idToRemove = input.nextInt();
                        boolean removed = false;

                        for (int i = 0; i < services.size(); i++) {
                            if (services.get(i).getID() == idToRemove) {
                                services.remove(i);
                                System.out.println("Service removed successfully.");
                                removed = true;
                                break;
                            }
                        }

                        if (!removed) {
                            System.out.println("Service not found.");
                        }
                        break;

                    case 4: // New Booking
    System.out.println("Enter service ID:");
    serviceID = input.nextInt();
    Service selectedService = null;

    for (Service service1 : services) {
        if (service1.getID() == serviceID) {
            selectedService = service1;
            break;
        }
    }

    if (selectedService == null) {
        System.out.println("Service ID is invalid");
        break;
    }

   
    System.out.println("Enter your ID:");
    int clientID = input.nextInt();  

    System.out.println("Enter your name:");
    String name = input.next();  

    System.out.println("Enter your phone number:");
    String phone = input.next();  

    System.out.println("Enter your payment type (cash/card):");
    String paymentType = input.next();  
    int cardID = 0;
    if (paymentType.equalsIgnoreCase("card")) {
        System.out.println("Enter your card ID:");
        cardID = input.nextInt(); 
    }

    
    Client c = new Client(clientID, name, phone, paymentType, cardID);

    
    System.out.println("Enter the date and time for your booking (Year Month Day Hour):");
    int year = input.nextInt();
    int month = input.nextInt();
    int day = input.nextInt();
    int hour = input.nextInt();
    ScheduleEntry s = new ScheduleEntry(301, new LocalDateTime(year, month, day, hour), false);

    
    B1 = new Booking(c, selectedService, s);

    
    System.out.println("Booking added successfully!");
    break;
                    case 5://show Booking
                        if (B1 != null) {
                            System.out.println(B1 );
                            System.out.printf("Total is %.2f SAR/n", B1 .getService().calcPrice());
                        } else {
                            System.out.println("No booking yet!");
                        }

                        break;

                    case 6:
                        //cancel booking
                        if (B1  != null) {System.out.print("Are you sure you want to cancel your Booking? (Y/N): ");
                            char answer;
                            answer = input.next().charAt(0);

                            if (answer == 'y' || answer == 'Y') {
                                B1 .setStatus("Cancelled");
                                System.out.println(B1 );
                               B1 .getScheduleEntry().setAvailable(true);

                                System.out.printf("Total is: %.2f SAR\n", B1 .getService().calcPrice());
                                System.out.println("Your booking has been cancelled!");
                            } else {
                                System.out.println("Your booking is still confirmed!");
                            }
                        } else {
                            System.out.println("No booking yet!");
                        }
                        break;

                    case 7:
                        GuiWashSystem.main(null);
                    case 8:// Write to files
                        WriteText wf = new WriteText();
                        wf.openTextFile("services.txt");
                        if (services.isEmpty()) {
                            System.out.println("No services yet.");
                        } else {
                            for (Service ele : services) {
                                wf.writeToFile(ele);
                            }
                        }
                        wf.closeFile();
                        System.out.println("All services saved to the text file services.txt");

                        break;

                    case 9:// Read from files
                        ReadText rt = new ReadText();
                        rt.openTextFile("services.txt");
                        rt.readFromFile();
                        rt.closeFile();
                        break;

                    case 10://Exit
                        System.out.println("Thank you!");

                        break;

                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Invalid input");
                input.nextLine();
            } catch (NullPointerException ex) {
                System.err.println(ex);
            } catch (ClassCastException ex) {
                System.err.println(ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println(ex);
            } catch (Exception ex) {
                System.err.println(ex);
            }

        } while (choice != 10);

    }

    public static void menu() {
        System.out.println("*** Welcome To Our Wash System ***"
                + "What do you want ? ");
        System.out.print("\n1. Show All Services\n"
                + "2. Show Wash Services\n"
                + "3. Remove Service \n4. New Booking\n"
                + "5. Show Booking\n"
                + "6. Cancel Booking\n"
                + "7. GUI\n"
                + "8. Write to files\n"
                + "9. Read from files\n"
                + "10.Exit\n"
                + ">> ");
    }

    public static void fillList(ArrayList<Service> list) {
        ScheduleEntry[] scheduleEntry = new ScheduleEntry[2];
        ScheduleEntry[] schedule = new ScheduleEntry[2];
        schedule[0] = new ScheduleEntry(201, new LocalDateTime(2025, 4, 22, 10), true);
        schedule[1] = new ScheduleEntry(202, new LocalDateTime(2025, 4, 22, 14), true);

        list.add(new Wash("Hand", 101, "Exterior Wash", 50, null));
        list.add(new Wash("Auto", 102, "Interior Wash", 50, null));
        list.add(new Polish("3D Speed Car", 103, "Interior Polish", 100, null));
        list.add(new Polish("Turtle Wax 1", 104, "Exterior Polish", 600, null));

    }
}