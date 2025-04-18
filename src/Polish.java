
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
