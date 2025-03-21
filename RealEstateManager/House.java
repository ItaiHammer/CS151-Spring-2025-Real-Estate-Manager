package RealEstateManager;

public class House extends RealEstate implements OccupiesLand, Rentable {
	
	

    public House(City city, String address, double price, int width, int height, RealEstateOwner owner) {
        super(address, price, width, height, owner);
        
    }
    
    //changes the width and height of the house by modifying the width and height, removing the property, and adding the property
    //saves initial width and height to reset the property if expansion fails
    //can expand to smaller widths or heights (assumes not negative)
    @Override
    public boolean expand(int x, int y) {
    	
    	int oldWidth = getWidth();
    	int oldHeight = getHeight();
    	this.setWidth(x);
    	this.setHeight(y);
    	int[] location = this.getLocation();
    	
    	City city = this.getCity();
    	
    	city.removeProperty(location[0], location[1]);
    	
    	if(!city.addProperty(this, location[0], location[1])) {
    		this.setWidth(oldWidth);
        	this.setHeight(oldHeight);
    		city.addProperty(this, location[0], location[1]);
    		return false;
    	}
    	
    	return true;
    }
    
    @Override
    public double getRent() {
    	return this.getPrice()/100;
    }
    
}
