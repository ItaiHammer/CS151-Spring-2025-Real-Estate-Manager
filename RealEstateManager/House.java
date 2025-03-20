package RealEstateManager;

public class House extends RealEstate implements OccupiesLand {
	
	

    public House(City city, String address, double price, int width, int height, RealEstateOwner owner) {
        super(city, address, price, width, height, owner);
        forSale = false;
        
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
    	return super.forSale;
    }
    
    
    //changes the width and height of the house by modifying the width and height, removing the property, and adding the property
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
