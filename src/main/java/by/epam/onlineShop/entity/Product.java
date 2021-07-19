package by.epam.onlineShop.entity;

public class Product implements Identifiable {
    private long id;
    private long categoryId;
    private long promotionId;
    private String name;
    private String description;
    private double price;
    private boolean status;
    private String photo;

    Product(long id, long categoryId, long promotionId, String name, String description,
            double price, boolean status, String photo) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.photo = photo;
    }

    @Override
    public long getId() {
        return id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public long getPromotionId() {
        return promotionId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return id == product.id &&
                categoryId == product.categoryId &&
                promotionId == product.promotionId &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                price == product.price &&
                status == product.status &&
                photo.equals(product.photo);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + (int) categoryId;
        result = prime * result + (int) promotionId;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (int) price;
        result = prime * result + Boolean.hashCode(status);
        result = prime * result + ((photo == null) ? 0 : photo.hashCode());
        return result;
    }
}
