package by.epam.onlineShop.entity;

import java.io.Serializable;

public class User implements Identifiable, Serializable {
    private long id;
    private long userInformationId;
    private String email;
    private String password;
    private long roleId;

    public User() {}

    public User(long id, long userInformationId, String email, String password, long roleId) {
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

    public void setId(long id) {
        this.id = id;
    }

    public long getUserInformationId() {
        return userInformationId;
    }

    public void setUserInformationId(long userInformationId) {
        this.userInformationId = userInformationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("User{");
        result.append("id=").append(id);
        result.append(", userInformationId=").append(userInformationId);
        result.append(", email='").append(email).append('\'');
        result.append(", password='").append(password).append('\'');
        result.append(", roleId=").append(roleId);
        result.append('}');
        return result.toString();
    }
}
