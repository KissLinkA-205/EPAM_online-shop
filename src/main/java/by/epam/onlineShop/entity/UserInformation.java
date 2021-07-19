package by.epam.onlineShop.entity;

public class UserInformation implements Identifiable {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private long phone;

    UserInformation(long id, String name, String surname, String patronymic, long phone) {
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public long getPhone() {
        return phone;
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
}
