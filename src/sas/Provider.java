package sas;

public final class Provider {

    private final int numberOfPots;
    private final int potPrice;
    private final String potName;

    public Provider(int potPrice, int numberOfPots) {
        this.numberOfPots = numberOfPots;
        this.potPrice = potPrice;
        this.potName = "Pot";
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
}
