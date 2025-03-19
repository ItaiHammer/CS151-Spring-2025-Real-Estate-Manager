abstract class RealEstate {
    private String address;
    private double price;
    private int width, height; 
    private RealEstateOwner owner;
    private boolean forSale;

    public RealEstate(String address, double price, int width, int height, RealEstateOwner owner) {
        this.address = address;
        this.price = price;
        this.width = width;
        this.height = height;
        this.owner = owner;
        forSale = true;
    }

    public RealEstateOwner getOwner() {
        return owner;
    }

    public void setOwner(RealEstateOwner owner) {
        this.owner = owner;
        forSale = true;
    }

    public boolean isForSale() {
        return forSale;
    }

    public abstract void setIsForSale();

    public int getArea() {
        return 0;
    }

    public void expand(int width, int height) {

    }

    public String toString() {
        return "";
    }
}
