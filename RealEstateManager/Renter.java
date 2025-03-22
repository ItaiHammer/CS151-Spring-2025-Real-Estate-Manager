package RealEstateManager;

public class Renter extends Person {
    private Rentable property;

    public Renter(String name, BankAccount bank) {
        super(name, bank);
    }

    public void rentProperty(Apartment apartment) {
        apartment.setRenter(this);
        this.property = apartment;              
        payRent();
    }

    public void payRent() {
        getBank().withdraw(property.getRent());
        ((RealEstate)property).getOwner().getBank().deposit(property.getRent());
    }
    
    public void terminateLease() {
        ((RealEstate)property).setRenter(null);
        this.property = null;
    }

    public String toString() {
        return "";
    }
}
