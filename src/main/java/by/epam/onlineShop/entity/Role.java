package by.epam.onlineShop.entity;

public enum Role {
    UNKNOWN(1), USER(2), ADMIN(3);

    private final long ID;

    Role(long id) {
        this.ID = id;
    }

    public long getId() {
        return ID;
    }
}
