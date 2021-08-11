package by.epam.onlineShop.dao;

import by.epam.onlineShop.entity.BankCard;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public interface BankCardDao {

    /**
     * Method to get bank card by card number from data base
     *
     * @param cardNumber number of the card
     * @return optional of BankCard
     * @throws DaoException
     */
    Optional<BankCard> findByCardNumber(long cardNumber) throws DaoException;

    /**
     * Method to update balance by bank card number in data base
     *
     * @param cardNumber number of bank card to update
     * @param newBalance new balance
     * @throws DaoException
     */
    void updateBalanceByCardNumber(long cardNumber, double newBalance) throws DaoException;
}
