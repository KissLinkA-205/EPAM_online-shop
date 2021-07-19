package by.epam.onlineShop.entity;

public class BankCard implements Identifiable {
    private long id;
    private long userInformationId;
    private long cardNumber;
    private int expirationMonth;
    private int expirationYear;
    private String cardOwner;

    BankCard(long id, long userInformationId, long cardNumber, int expirationMonth, int expirationYear, String cardOwner) {
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

    public long getUserInformationId() {
        return userInformationId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public String getCardOwner() {
        return cardOwner;
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
}
