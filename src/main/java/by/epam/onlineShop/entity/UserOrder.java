package by.epam.onlineShop.entity;

import java.util.Date;

public class UserOrder implements Identifiable {
    private long id;
    private long userId;
    private String address;
    private Date orderDate;
    private Date deliveryDate;
    private boolean status;

    UserOrder(long id, long userId, String address, Date orderDate, Date deliveryDate, boolean status) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    @Override
    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        UserOrder userOrder = (UserOrder) o;
        return id == userOrder.id &&
                userId == userOrder.userId &&
                address.equals(userOrder.address) &&
                orderDate == userOrder.orderDate &&
                deliveryDate == userOrder.deliveryDate &&
                status == userOrder.status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + (int) userId;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + orderDate.hashCode();
        result = prime * result + deliveryDate.hashCode();
        result = prime * result + Boolean.hashCode(status);
        return result;
    }
}
