/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Service> services = new ArrayList<Service>();
        fillList(services);

        System.out.println("-------Welcome To Car Wash Booking System!-------");
        System.out.println("Select one of the following options to continue:");

        int choice;
        Booking booking = null;
        do {
            menu();
            choice = input.nextInt();//Name Object of Scanner
            switch (choice) {

                case 1://show all services
                    System.out.println("***All services***");
                    for (Service service : services) {
                        System.out.println(service);//toString
                        service.displaySchedulEntry();
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

                case 4:

                    break;

                case 5://show Booking
                    if (booking != null) {
                        System.out.println(booking);
                        System.out.printf("Total is %.2 SAR/n", booking.getService().calcPrice());
                    } else {
                        System.out.println("No booking yet!");
                    }

                    break;

                case 6:

                    break;

                case 7://cancel booking
                    if (booking != null) {
                        System.out.print("Are you sure you want to cancel your Booking? (Y/N): ");
                        char answer;
                        answer = input.next().charAt(0);

                        if (answer == 'y' || answer == 'Y') {
                            booking.setStatus("Cancelled");
                            System.out.println(booking);

                            booking.getScheduleEntry().setAvailable(true);

                            System.out.printf("Total is: %.2f SAR\n", booking.getService().calcPrice());
                            System.out.println("Your booking has been cancelled!");
                        } else {
                            System.out.println("Your booking is still confirmed!");
                        }
                    } else {
                        System.out.println("No booking yet!");
                    }
                    break;

                case 8:

                    break;

                case 9:

                    break;

                case 10:

                    break;
                case 11://Exit
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 11);

    }

    public static void menu() {
        System.out.println("*** Welcome To Our Wash System ***"
                + "What do you want ? ");
        System.out.print("\n1. Show All Services\n"
                + "2. Show Wash Services\n"
                + "3. Remove Service"
                + "4. Add Appointment\n"
                + "5. New Booking\n"
                + "6. Show Booking\n"
                + "7. Cancel Booking\n"
                + "8. GUI"
                + "9. Read from files"
                + "10. Write to files"
                + "11. Exit\n"
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
