abstract class RentalItem {
    private String name;
    private double price;

    public RentalItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract double calculateRentalCost(int days);
}
