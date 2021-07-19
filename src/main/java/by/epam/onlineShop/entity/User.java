package by.epam.onlineShop.entity;

public class User implements Identifiable {
    private long id;
    private long userInformationId;
    private String email;
    private String password;
    private long roleId;

    User(long id, long userInformationId, String email, String password, long roleId) {
        this.id = id;
        this.userInformationId = userInformationId;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getRoleId() {
        return roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        User user = (User) o;
        return id == user.id &&
                userInformationId == user.userInformationId &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                roleId == user.roleId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + (int) userInformationId;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + (int) roleId;
        return result;
    }
}
