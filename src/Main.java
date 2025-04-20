/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Main {

    public static void main(String[] args) {
     Scanner input = new Scanner (System.in);
        
        int choice;
        do {
            menu();
            choice = input.nextInt();//Name Object of Scanner
            switch (choice) {

                case 1://show all services
                 System.out.println("***All services***");
                  for(service service : services);
                  System.out.println(service);//toString
                  service.displaySchedulEntry();
                  System.out.println("-------------------------------------");

                    break;
                    
                case 2:// Show Wash Services
                    
                    System.out.println("*** Wash Services ***");
                    for (Service Listservice : services) {// Name of ArrayList
                        if (Listservice instanceof Wash) {
                            System.out.println(Listservice);
                            System.out.println("-------------------------------------");
                        }
                    }break;

                case 3:

                    break;

                case 4:

                    break;

                case 5://show Booking
                     if (booking != null){
                     System.out.println(booking); 
                     System.out.printf("Total is %.2 SAR/n", booking.getService().calcPrice());
                    }else{
                     System.out.println("No booking yet!");
                    }

                    break;

                case 6:

                    break;

                case 7:

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

}
