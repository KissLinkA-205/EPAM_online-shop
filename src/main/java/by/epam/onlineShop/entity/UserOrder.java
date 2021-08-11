package by.epam.onlineShop.entity;

import java.util.Date;

public class UserOrder implements Identifiable {
    private long id;
    private String address;
    private Date orderDate;
    private Date deliveryDate;
    private String status;

    public UserOrder() {

    }

    public UserOrder(long id, String address, Date orderDate, Date deliveryDate, String status) {
        this.id = id;
        this.address = address;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        UserOrder userOrder = (UserOrder) o;
        return id == userOrder.id &&
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
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + orderDate.hashCode();
        result = prime * result + deliveryDate.hashCode();
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("UserOrder{");
        result.append("id=").append(id);
        result.append(", address='").append(address).append('\'');
        result.append(", orderDate=").append(orderDate);
        result.append(", deliveryDate=").append(deliveryDate);
        result.append(", status='").append(status).append('\'');
        result.append('}');
        return result.toString();
    }
}
