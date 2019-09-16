public class Car {
    // Instance variables
    private String make;
    private String model;
    private int year;
    private int odometer;
    private String colour;
    private int price;

    // Constructor
    public Car(String make, String model, int year, int odometer, String colour, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometer = odometer;
        this.colour = colour;
        this.price = price;
    }

    // Getter
    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }
    public int getYear() {
        return this.year;
    }
    public int getOdometer() {
        return this.odometer;
    }
    public String getColour() {
        return this.colour;
    }
    public int getPrice() {
        return this.price;
    }
}
