package RealEstateManager;

public class RealEstateAgent {
    private double commissionRate;
    private Person person;

    public RealEstateAgent(double commissionRate, Person person) {
        this.commissionRate = commissionRate;
        this.person = person;
    }

    public void finalizeSale(RealEstate property, RealEstateOwner buyer) {
        buyer.getBank().withdraw(property.getPrice());
        property.getOwner().getBank().deposit((1 - commissionRate)* property.getPrice());
        person.getBank().deposit(commissionRate * property.getPrice());
    }
}
