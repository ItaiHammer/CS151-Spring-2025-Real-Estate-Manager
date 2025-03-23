package RealEstateManager;

public class Renter extends Person {
    private Rentable rentedProperty;

    public Renter(String name) {
        super(name);
    }
    public void rentProperty(Rentable property) throws InsufficientFundsException {
        RealEstate p = (RealEstate)property;
        p.setRenter(this);
        rentedProperty = property;              
        payRent();
    }

    public void payRent() throws InsufficientFundsException{
        getBank().withdraw(rentedProperty.getRent());
        ((RealEstate)rentedProperty).getOwner().getBank().deposit(rentedProperty.getRent());
    }
    
    public void terminateLease() {
        ((RealEstate)rentedProperty).setRenter(null);
        this.rentedProperty = null;
    }

    public String toString() {
        return "Renter{" + 
                "rentedProperty= " + rentedProperty + 
                " " + super.toString() + 
                "}";
    }
}
