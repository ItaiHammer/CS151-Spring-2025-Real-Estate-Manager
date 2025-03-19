package RealEstateManager;

import java.util.ArrayList;

public class RealEstateOwner extends Person {

    public RealEstateOwner(String name, BankAccount bank) {
        super(name, bank);
    }
    public void leaseToRenter() {

    }

    private ArrayList<RealEstate> propertiesOwned()
    {
        return new ArrayList<RealEstate>(0);
    }

    public void searchProperty(RealEstate property) {

    }

    public void buyProperty(RealEstate property) {

    }

    public void leaseProperty(RealEstate property, Renter renter) {

    }

    public void evictRenter(RealEstate property) {

    }

    public String toString() {
        return "";
    }
}