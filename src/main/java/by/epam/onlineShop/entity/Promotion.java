package by.epam.onlineShop.entity;

import jdk.jfr.DataAmount;

import java.util.Date;

public class Promotion implements Identifiable {
    private long id;
    private String name;
    private String description;
    private byte discount;
    private Date beginningDate;
    private Date expirationDate;

    Promotion(long id, String name, String description, byte discount, Date beginningDate, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.beginningDate = beginningDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public byte getDiscount() {
        return discount;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;
        return id == promotion.id &&
                name.equals(promotion.name) &&
                description.equals(promotion.description) &&
                discount == promotion.discount &&
                beginningDate == promotion.beginningDate &&
                expirationDate == promotion.expirationDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (int) discount;
        result = prime * result + beginningDate.hashCode();
        result = prime * result + expirationDate.hashCode();
        return result;
    }
}
