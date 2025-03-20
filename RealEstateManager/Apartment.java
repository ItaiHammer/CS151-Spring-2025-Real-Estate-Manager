package RealEstateManager;

public class Apartment extends RealEstate {
	private ApartmentBuilding apartmentBuilding;
    private int unit;
    private int floor;

    //should only be created by ApartmentBuilding constructor
    public Apartment(City city, String address, double price, int width, int height, RealEstateOwner owner,  int unit, int floor) {
        super(city, address, price, width, height, owner);
        this.unit = unit;
        this.floor = floor;
    }
    
    @Override
    public void setIsForSale() {
    	forSale = true;
    }
    
    @Override
    public void setNotForSale() {
    	forSale = false;
    }

    @Override
    public boolean isForSale() {
    	return forSale;
    }

    public int getUnit() {
        return unit;
    }

    public int getFloor() {
        return floor;
    }
    
    //expands the apartment building the apartment is a part of
    @Override
    public boolean expand(int x, int y) {
    	return apartmentBuilding.expand(x, y);
    }
}
