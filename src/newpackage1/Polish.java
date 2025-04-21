
package newpackage1;

public class Polish extends Service {

    private String Chemical;

    public Polish(String Chemical) {
        this.Chemical = Chemical;
    }

    public Polish(String Chemical, int ID, String name, double price, ScheduleEntry[] schedulEntry) {
        super(ID, name, price, schedulEntry);
        this.Chemical = Chemical;
    }

    public String getChemical() {
        return Chemical;
    }

    public void setChemical(String Chemical) {
        this.Chemical = Chemical;
    }

    public String describeService() {
        return "Car Polish Service:\n"
                + "This service includes the application of a high-quality " + Chemical + " polish to your vehicle.\n"
                + "Type: " + Chemical + " based car polish.\n"
                + "How to Use: The car is first thoroughly washed and dried. Then, the polish is applied using a soft cloth or buffer in circular motions.\n"
                + "This process enhances the vehicle's shine, removes minor scratches, and protects the paint from environmental damage.\n"
                + "Service Name: " + getName() + "\n"
                + "Price: " + calcPrice() + " SAR.\n"
                + "Schedule: Please refer to the available schedule entries for booking.";
    }

    @Override
    public String toString() {
        return "Polish{" + "Chemical=" + Chemical + '}';
    }

    @Override
    public double calcPrice() {
        double basePrice = super.getPrice();
        double ChemicalMultiplier = 1.0;
        if (Chemical.equals("Special")) {
            ChemicalMultiplier = 1.5;
        }
        return basePrice * ChemicalMultiplier;

    }

}