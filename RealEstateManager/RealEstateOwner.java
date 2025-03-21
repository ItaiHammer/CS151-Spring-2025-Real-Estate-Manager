package RealEstateManager;

import java.util.ArrayList;

public class RealEstateOwner extends Person {
    private ArrayList<RealEstate> properties;

    public RealEstateOwner(String name, BankAccount bank) {
        super(name, bank);
        properties = new ArrayList<RealEstate>();
    }

    private ArrayList<RealEstate> propertiesOwned() {
        return properties;
    }

    public void buyProperty(RealEstate property, RealEstateAgent agent) {
        agent.finalizeSale(property, this);
        properties.add(property);
        property.setOwner(this);
    }

    public void evictRenter(RealEstate property) {
        property.getRenter().terminateLease();
    }

    public String toString() {
        return "";
    }
}