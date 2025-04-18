
public class Wash extends Service {

    private String type;

    public Wash(String type) {
        this.type = type;
    }

    public Wash(String type, int ID, String name, double price, ScheduleEntry[] schedulEntry) {
        super(ID, name, price, schedulEntry);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Wash{" + "type=" + type + '}';
    }

    @Override
    public double calcPrice() {
        double basePrice = super.getPrice();
        double typeMultiplier = 1.0;
        if (type.equals("deluxe")) {
            typeMultiplier = 1.3;

        } else if (type.equals("standars")) {
            typeMultiplier = 1.0;

        }double finalPrice=basePrice *typeMultiplier ;
        return finalPrice;

    }

}
