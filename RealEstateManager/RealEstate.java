package RealEstateManager;

public abstract class RealEstate {
    private City city;
    private String address;
    private double price;
    private int width, height;
    private RealEstateOwner owner;
    private boolean forSale;
    private boolean forRent;
    private Renter renter;
    private int topLeftX;
    private int topLeftY;
    private boolean hasYard;
    private boolean hasPool;
    private String style;

    public RealEstate(String address, double price, int width, int height, RealEstateOwner owner) {
        this.address = address;
        this.price = price;
        this.width = width;
        this.height = height;
        this.owner = owner;
        this.forSale = false;
        this.forRent = false;
        this.hasYard = false;
        this.hasPool = false;
        this.style = "unknown";
    }

    public void setOwner(RealEstateOwner owner) {
        this.owner = owner;
        forSale = true;
    }

    public RealEstateOwner getOwner() {
        return owner;
    }

    public void setIsForSale() {
    	forSale = true;
    }
    
    public void setNotForSale() {
    	forSale = false;
    }

    public boolean isForSale() {
    	return forSale;
    }
    
    public void setIsForRent() {
    	forRent = true;
    }
    
    public void setNotForRent() {
    	forRent = false;
    }

    public boolean isForRent() {
    	return forRent;
    }
    
    public double getPrice() {
		return price;
	}
    
    public int getArea() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public void setWidth(int width) {
		this.width = width;
	}
    
    public void setHeight(int height) {
		this.height = height;
	}

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String newAddress) {
    	this.address = newAddress;
    }

    public int[] getLocation() {
        return new int[]{topLeftX, topLeftY};
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public void setLocation(int x, int y) {
        this.topLeftX = x;
        this.topLeftY = y;
    }
    
    public City getCity() {
        return city;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
    }

    public boolean hasYard() {
        return hasYard;
    }

    public void setHasYard(boolean hasYard) {
        this.hasYard = hasYard;
    }

    public boolean hasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String toString() {
        return "RealEstate{" +
                "city=" + city +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", width=" + width +
                ", height=" + height +
                ", owner=" + owner +
                ", forSale=" + forSale +
                ", forRent=" + forRent +
                ", renter=" + renter +
                ", topLeftX=" + topLeftX +
                ", topLeftY=" + topLeftY +
                ", hasYard=" + hasYard +
                ", hasPool=" + hasPool +
                ", style='" + style + '\'' +
                '}';
    }

	public abstract boolean expand(int x, int y);
}
