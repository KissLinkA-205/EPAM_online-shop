package by.epam.onlineShop.entity;

public class UserInformation implements Identifiable {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private long phone;

    public UserInformation() {}

    public UserInformation(long id, String name, String surname, String patronymic, long phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        UserInformation userInformation = (UserInformation) o;
        return id == userInformation.id &&
                name.equals(userInformation.name) &&
                surname.equals(userInformation.surname) &&
                patronymic.equals(userInformation.patronymic) &&
                phone == userInformation.phone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
        result = prime * result + (int) phone;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("UserInformation{");
        result.append("id=").append(id);
        result.append(", name='").append(name).append('\'');
        result.append(", surname='").append(surname).append('\'');
        result.append(", patronymic='").append(patronymic).append('\'');
        result.append(", phone=").append(phone);
        result.append('}');
        return result.toString();
    }
}
