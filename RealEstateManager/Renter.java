package RealEstateManager;

public class Renter extends Person {
    private Apartment apartment;

    public Renter(String name, BankAccount bank) {
        super(name, bank);
    }

    public void rentProperty(Apartment apartment) {
        apartment.setRenter(this);
        this.apartment = apartment;
        payRent();
    }

    public void payRent() {
        getBank().withdraw(apartment.getPrice());
        apartment.getOwner().getBank().deposit(apartment.getPrice());
    }

    public void terminateLease() {
        apartment.setRenter(null);
        this.apartment = null;
    }

    public String toString() {
        return "";
    }
}
