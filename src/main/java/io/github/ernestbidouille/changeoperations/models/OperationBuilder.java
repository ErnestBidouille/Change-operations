package io.github.ernestbidouille.changeoperations.models;

public class OperationBuilder {
    private String sourceDevise;
    private String destinationDevise;
    private int amount;

    public String getSourceDevise() {
        return sourceDevise;
    }

    public void setSourceDevise(String sourceDevise) {
        this.sourceDevise = sourceDevise;
    }

    public String getDestinationDevise() {
        return destinationDevise;
    }

    public void setDestinationDevise(String destinationDevise) {
        this.destinationDevise = destinationDevise;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
