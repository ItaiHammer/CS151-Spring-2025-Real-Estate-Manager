package RealEstateManager;

abstract class Person {
    private String name;
    private BankAccount bank;

    public Person(String name, BankAccount bank)
    {
        this.name = name;
        this.bank = bank;
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
        return "";
    }
}