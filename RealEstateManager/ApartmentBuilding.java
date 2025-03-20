package RealEstateManager;

public class ApartmentBuilding extends RealEstate implements OccupiesLand {
    private Apartment[][] apartments;
    
    public ApartmentBuilding(City city, String address, double price, int width, int height, RealEstateOwner owner, int floors, int unitsPerFloor) {
        super(city, address, price, width, height, owner);
        apartments = new Apartment[floors][unitsPerFloor];
        double apartmentPrice = price/floors/unitsPerFloor; //initial price of each apartment

        for (int curFloor = 0; curFloor < apartments.length; curFloor++) {
            for (int curUnit = 0; curUnit < apartments[curFloor].length; curUnit++) {
            	apartments[curFloor][curUnit] = new Apartment(city, address, apartmentPrice, width, height, owner,  curFloor, curUnit); //note: first floor is 0
            }
        }
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
    
  //changes the width and height of the apartment building by modifying the width and height, removing the property, and adding the property
  //saves initial width and height to reset the property if expansion fails
  //can expand to smaller widths or heights (assumes not negative)
    @Override
    public boolean expand(int x, int y) {
    	
    	int oldWidth = width;
    	int oldHeight = height;
    	width = x;
    	height = y;
    	int[] location = this.getLocation();
    	
    	City city = this.getCity();
    	
    	city.removeProperty(location[0], location[1]);
    	
    	if(!city.addProperty(this, location[0], location[1])) {
    		width = oldWidth;
    		height = oldHeight;
    		city.addProperty(this, location[0], location[1]);
    		return false;
    	}
    	
    	return true;
    }
    
}
