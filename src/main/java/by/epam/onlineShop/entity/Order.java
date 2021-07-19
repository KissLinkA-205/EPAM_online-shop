package by.epam.onlineShop.entity;

public class Order implements Identifiable {
    private long id;
    private long productId;
    private long userOrderId;
    private int number;

    Order(long id, long productId, long userOrderId, int number) {
        this.id = id;
        this.productId = productId;
        this.userOrderId = userOrderId;
        this.number = number;
    }

    @Override
    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public long getUserOrderId() {
        return userOrderId;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return id == order.id &&
                productId == order.productId &&
                userOrderId == order.userOrderId &&
                number == order.number;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + (int) productId;
        result = prime * result + (int) userOrderId;
        result = prime * result + number;
        return result;
    }
}
