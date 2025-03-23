package RealEstateManager;

import java.util.ArrayList;

public class RealEstateOwner extends Person {
    private ArrayList<RealEstate> properties;

    public RealEstateOwner(String name) {
        super(name);
        properties = new ArrayList<RealEstate>();
    }

    public ArrayList<RealEstate> propertiesOwned() {
        return properties;
    }

    public void addProperty(RealEstate property) {
        properties.add(property);
    }

    public void buyProperty(RealEstate property, RealEstateAgent agent) throws InsufficientFundsException{
        agent.finalizeSale(property, this);
        properties.add(property);
        property.setOwner(this);
    }

    public void terminateContract(RealEstate property) {
        if(property.getRenter() == null) {
            System.out.println("Terminate failed: no renter.");
        }
        else {
            property.getRenter().terminateLease();
        }
    }

    public String toString() {
        return "RealEstateOwner{" + 
                "Number of properties= " + properties.size() + 
                " " + super.toString() + 
                "}";
    }
}