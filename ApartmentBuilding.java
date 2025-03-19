public class ApartmentBuilding extends RealEstate {
    private Apartment[][] apartments;
    
    public ApartmentBuilding(String address, double price, int width, int height, RealEstateOwner owner, Apartment[][] apartments) {
        super(address, price, width, height, owner);
        this.apartments = apartments;
    }
    @Override
    public void setIsForSale() {

    	//hello
    }

    
}
