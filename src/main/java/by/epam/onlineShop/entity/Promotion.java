package by.epam.onlineShop.entity;

import java.io.Serializable;
import java.util.Date;

public class Promotion implements Serializable, Identifiable {
    private long id;
    private String name;
    private String description;
    private byte discount;
    private Date beginningDate;
    private Date expirationDate;
    private String photo;

    public Promotion() {}

    public Promotion(long id, String name, String description, byte discount, Date beginningDate, Date expirationDate, String photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.beginningDate = beginningDate;
        this.expirationDate = expirationDate;
        this.photo = photo;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getDiscount() {
        return discount;
    }

    public void setDiscount(byte discount) {
        this.discount = discount;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
                expirationDate == promotion.expirationDate &&
                photo.equals(promotion.photo);
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
        result = prime * result + ((photo == null) ? 0 : photo.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("Promotion{");
        result.append("id=").append(id);
        result.append(", name='").append(name).append('\'');
        result.append(", description='").append(description).append('\'');
        result.append(", discount=").append(discount);
        result.append(", beginningDate=").append(beginningDate);
        result.append(", expirationDate=").append(expirationDate);
        result.append(", photo='").append(photo).append('\'');
        result.append('}');
        return result.toString();
    }
}
