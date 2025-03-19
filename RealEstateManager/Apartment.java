package RealEstateManager;

public class Apartment {
    private int unit;
    private int floor;

    public Apartment(int unit, int floor) {
        this.unit = unit;
        this.floor = floor;
    }

    public int getUnit() {
        return unit;
    }

    public int getFloor() {
        return floor;
    }
}
