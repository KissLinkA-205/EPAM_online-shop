package by.epam.onlineShop.entity;

public class Category implements Identifiable {
    private long id;
    private String categoryName;


    public Category() { }

    public Category(long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return id == category.id &&
                categoryName.equals(category.categoryName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("Category{");
        result.append("id=").append(id);
        result.append(", categoryName='").append(categoryName).append('\'');
        result.append('}');
        return result.toString();
    }
}
