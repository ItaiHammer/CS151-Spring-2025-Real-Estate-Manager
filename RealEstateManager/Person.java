package RealEstateManager;

abstract class Person {
    private String name;
    private BankAccount bank;

    public Person(String name)
    {
        this.name = name;
        bank = new BankAccount(1000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccount getBank() {
        return bank;
    }

    public void setBank(BankAccount bank) {
        this.bank = bank;
    }

    public String toString() {
        return "Person{"+ 
                "name= " + name + 
                "}";
    }
}