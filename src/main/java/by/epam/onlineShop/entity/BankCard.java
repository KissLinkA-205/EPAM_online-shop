package by.epam.onlineShop.entity;

public class BankCard implements Identifiable {
    private long id;
    private long userInformationId;
    private long cardNumber;
    private int expirationMonth;
    private int expirationYear;
    private String cardOwner;

    public BankCard() { }

    public BankCard(long id, long userInformationId, long cardNumber, int expirationMonth, int expirationYear, String cardOwner) {
        this.id = id;
        this.userInformationId = userInformationId;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cardOwner = cardOwner;
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

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        BankCard bankCard = (BankCard) o;
        return id == bankCard.id &&
                userInformationId == bankCard.userInformationId &&
                cardNumber == bankCard.cardNumber &&
                expirationMonth == bankCard.expirationMonth &&
                expirationYear == bankCard.expirationYear &&
                cardOwner.equals(bankCard.cardOwner);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) id;
        result = prime * result + (int) userInformationId;
        result = prime * result + (int) cardNumber;
        result = prime * result + expirationMonth;
        result = prime * result + expirationYear;
        result = prime * result + ((cardOwner == null) ? 0 : cardOwner.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("BankCard{");
        result.append("id=").append(id);
        result.append(", userInformationId=").append(userInformationId);
        result.append(", cardNumber=").append(cardNumber);
        result.append(", expirationMonth=").append(expirationMonth);
        result.append(", expirationYear=").append(expirationYear);
        result.append(", cardOwner='").append(cardOwner).append('\'');
        result.append('}');
        return result.toString();
    }
}
