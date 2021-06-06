package by.epam.onlineShop.entity;

import java.util.Objects;

public class BankCard {
    private long id;
    private long cardNumber;
    private int expirationMonth;
    private int expirationYear;
    private String cardOwner;

    BankCard(long id, long cardNumber, int expirationMonth, int expirationYear, String cardOwner) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cardOwner = cardOwner;
    }

    public long getId() {
        return id;
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
                cardNumber == bankCard.cardNumber &&
                expirationMonth == bankCard.expirationMonth &&
                expirationYear == bankCard.expirationYear &&
                cardOwner.equals(bankCard.cardOwner);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cardOwner == null) ? 0 : cardOwner.hashCode());
        result = prime * result + (int) id;
        result = prime * result + (int) cardNumber;
        result = prime * result + expirationMonth;
        result = prime * result + expirationYear;
        return result;
    }
}
