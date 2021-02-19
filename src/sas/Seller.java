package sas;

public final class Seller {

    private int numberOfPots;
    private int potPrice;
    private int money;
    private String potName;

    public Seller(int potPrice, int numberOfPots, int money) {
        this.numberOfPots = numberOfPots;
        this.potPrice = potPrice;
        this.money = money;
        this.potName = "Pot";
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public int getNumberOfPots() {
        return numberOfPots;
    }

    public int getPotPrice() {
        return potPrice;
    }

    public String getPotName() {
        return potName;
    }

    public int getMoney() {
        return money;
    }
}
