package RealEstateManager;

public class ApartmentBuilding extends RealEstate implements OccupiesLand {
    private Apartment[][] apartments;
    
    public ApartmentBuilding(String address, double price, int width, int height, RealEstateOwner owner, int floors, int unitsPerFloor) {
        super(address, price, width, height, owner);
        apartments = new Apartment[floors][unitsPerFloor];
        double apartmentPrice = price/floors/unitsPerFloor; //initial price of each apartment

        for (int curFloor = 0; curFloor < apartments.length; curFloor++) {
            for (int curUnit = 0; curUnit < apartments[curFloor].length; curUnit++) {
            	apartments[curFloor][curUnit] = new Apartment(address, apartmentPrice, width, height, owner,  curFloor, curUnit, this); //note: first floor is 0
            }
        }
    }
    
  //changes the width and height of the apartment building by modifying the width and height, removing the property, and adding the property
  //saves initial width and height to reset the property if expansion fails
  //can expand to smaller widths or heights (assumes not negative)
    @Override
    public boolean expand(int x, int y) throws InvalidPropertyDimensionsException, PropertyAlreadyExistsException {
        if (x <= 0 || y <= 0) {
            throw new InvalidPropertyDimensionsException("Invalid dimensions for expanding the apartment building: The new width and height must be positive and within the city's grid limits.");
        }
        
        City city = this.getCity();
        int[] location = this.getLocation();
        city.removeProperty(location[0], location[1]);
        
        int oldWidth = getWidth();
        int oldHeight = getHeight();
        this.setWidth(x);
        this.setHeight(y);
        
        if (!city.addProperty(this, location[0], location[1])) {
            this.setWidth(oldWidth);
            this.setHeight(oldHeight);
            city.addProperty(this, location[0], location[1]);
            throw new InvalidPropertyDimensionsException("Invalid dimensions for expanding the apartment building: The new width and height must not overlap another property.");
        }
        
    	for(Apartment[] aparts: apartments) {
    		for(Apartment a: aparts) {
    			a.setWidth(x);
    			a.setHeight(y);
    		}
    	}
        return true;
    }
    
    //setter should also change apartment
    @Override
    public void setCity(City city)  {
    	super.setCity(city);
    	for(Apartment[] aparts: apartments) {
    		for(Apartment a: aparts) {
    			a.setCity(city);
    		}
    	}
    }
    
    @Override
    public void setAddress(String address)  {
    	super.setAddress(address);
    	for(Apartment[] aparts: apartments) {
    		for(Apartment a: aparts) {
    			a.setAddress(address);
    		}
    	}
    }
    
    @Override
    public void setHasYard(boolean hasYard) {
    	super.setHasYard(hasYard);
    	for(Apartment[] aparts: apartments) {
    		for(Apartment a: aparts) {
    			a.setHasYard(hasYard);
    		}
    	}
    }
    
    @Override
    public void setHasPool(boolean hasPool) {
    	super.setHasPool(hasPool);
    	for(Apartment[] aparts: apartments) {
    		for(Apartment a: aparts) {
    			a.setHasPool(hasPool);
    		}
    	}
    }
    
    @Override
    public void setStyle(String style){
    	super.setStyle(style);
    	for(Apartment[] aparts: apartments) {
    		for(Apartment a: aparts) {
    			a.setStyle(style);
    		}
    	}
    }
    
    @Override
    public void setLocation(int x, int y){
    	super.setLocation(x, y);
    	for(Apartment[] aparts: apartments) {
    		for(Apartment a: aparts) {
    			a.setLocation(x, y);
    		}
    	}
    }
    
    public Apartment getApartment(int floor, int unit) {
    	return apartments[floor][unit];
    }
    
    @Override
    public String toString() {
    	
    	return "ApartmentBuilding " + super.toString();
    }
}
