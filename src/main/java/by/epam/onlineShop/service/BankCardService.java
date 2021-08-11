package by.epam.onlineShop.service;

import by.epam.onlineShop.exeptions.ServiceException;

public interface BankCardService {

    /**
     * Method to check exist of bank card
     *
     * @param cardNumber      number of bank card
     * @param expirationMonth expiration month of bank card
     * @param expirationYear  expiration year of bank card
     * @param cvv             cvv code of bank card
     * @return {@code true} if bank card exist, {@code false} otherwise
     * @throws ServiceException
     */
    boolean isBankCardExist(long cardNumber, int expirationMonth, int expirationYear, int cvv) throws ServiceException;

    /**
     * Method for order payment
     *
     * @param cardNumber      number of bank card
     * @param expirationMonth expiration month of bank card
     * @param expirationYear  expiration year of bank card
     * @param cvv             cvv code of bank card
     * @param price           payment price
     * @return {@code true} if payment passed, {@code false} otherwise
     * @throws ServiceException
     */
    boolean makePayment(long cardNumber, int expirationMonth, int expirationYear, int cvv, double price) throws ServiceException;
}
