package list.arraylist;

public class Vehicle {
    private String brand;
    private Integer makeYear;

    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getMakeYear() {
        return makeYear;
    }
}
