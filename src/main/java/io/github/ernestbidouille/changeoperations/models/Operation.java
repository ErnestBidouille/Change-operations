package io.github.ernestbidouille.changeoperations.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            updatable = false
    )
    private Long id;

    private String sourceDevise;

    private String destinationDevise;

    private int amount;

    private Date date;

    private Double rate;

    public Operation() {
    }

    public Operation(String sourceDevise, String destinationDevise, int amount, Date date, Double rate) {
        this.sourceDevise = sourceDevise;
        this.destinationDevise = destinationDevise;
        this.amount = amount;
        this.date = date;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
