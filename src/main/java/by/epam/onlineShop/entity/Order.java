package by.epam.onlineShop.entity;

public class Order implements Identifiable {
    private long id;
    private long productId;
    private long userId;
    private long userOrderId;
    private int number;

    public Order() {}

    public Order(long id, long productId, long userId, long userOrderId, int number) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.userOrderId = userOrderId;
        this.number = number;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserOrderId() {
        return userOrderId;
    }

    public void setUserOrderId(long userOrderId) {
        this.userOrderId = userOrderId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return id == order.id &&
                productId == order.productId &&
                userId == order.userId &&
                userOrderId == order.userOrderId &&
                number == order.number;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + (int) productId;
        result = prime * result + (int) userId;
        result = prime * result + (int) userOrderId;
        result = prime * result + number;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("Order{");
        result.append("id=").append(id);
        result.append(", productId=").append(productId);
        result.append(", userId=").append(userId);
        result.append(", userOrderId=").append(userOrderId);
        result.append(", number=").append(number);
        result.append('}');
        return result.toString();
    }
}
