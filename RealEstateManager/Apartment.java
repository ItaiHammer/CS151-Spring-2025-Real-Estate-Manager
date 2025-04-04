package RealEstateManager;

public class Apartment extends RealEstate implements Rentable {
	private ApartmentBuilding apartmentBuilding;
    private int unit;
    private int floor;

    //should only be created by ApartmentBuilding constructor
    public Apartment(String address, double price, int width, int height, RealEstateOwner owner,  int unit, int floor, ApartmentBuilding apartmentBuilding) {
        super(address, price, width, height, owner);
        this.apartmentBuilding = apartmentBuilding;
        this.unit = unit;
        this.floor = floor;
    }

    public int getUnit() {
        return unit;
    }

    public int getFloor() {
        return floor;
    }
    
    //expands the apartment building the apartment is a part of
    @Override
    public boolean expand(int x, int y) throws InvalidPropertyDimensionsException, PropertyAlreadyExistsException {
    	return apartmentBuilding.expand(x, y);
    }
    
    @Override
    public double getRent() {
    	return (0.0+Math.round(this.getPrice()))/100;
    }
    
    @Override
    public String toString() {
    	
    	return "Apartment "+ " floor=" + floor +
                ", unit=" + unit + super.toString();
    }
}
