package RealEstateManager;

public abstract class RealEstate {
    private City city;
    private String address;
    private double price;
    protected int width, height;
    private RealEstateOwner owner;
    protected boolean forSale;
    protected boolean forRent;
    private Renter renter;
    private int topLeftX;
    private int topLeftY;

    public RealEstate(City city, String address, double price, int width, int height, RealEstateOwner owner) {
        this.city = city;
        this.address = address;
        this.price = price;
        this.width = width;
        this.height = height;
        this.owner = owner;
        this.forSale = false;
        this.forRent = false;
    }

    public void setOwner(RealEstateOwner owner) {
        this.owner = owner;
        forSale = true;
    }

    public RealEstateOwner getOwner() {
        return owner;
    }

    public abstract boolean isForSale();

    public abstract void setIsForSale(); 
    
    public abstract void setNotForSale(); 

    public int getArea() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getAddress() {
        return address;
    }

    public int[] getLocation() {
        return new int[]{topLeftX, topLeftY};
    }

    public void setLocation(int x, int y) {
        this.topLeftX = x;
        this.topLeftY = y;
    }
    
    public City getCity() {
        return city;
    }

    public abstract boolean expand(int x, int y);

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
                '}';
    }
}
