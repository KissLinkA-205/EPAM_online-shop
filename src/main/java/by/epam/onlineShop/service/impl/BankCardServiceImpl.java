package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.BankCardDao;
import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.entity.BankCard;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.BankCardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class BankCardServiceImpl implements BankCardService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean isBankCardExist(long cardNumber, int expirationMonth, int expirationYear, int cvv) throws ServiceException {
        BankCardDao bankCardDao = DaoFactory.getInstance().getBankCardDao();
        try {
            Optional<BankCard> bankCard = bankCardDao.findByCardNumber(cardNumber);
            if (bankCard.isPresent()) {
                if (isBankCardInformationCorrect(bankCard.get(), cardNumber, expirationMonth, expirationYear, cvv)) {
                    return true;
                }
            }
        } catch (DaoException e) {
            logger.error("Unable to check card!");
            throw new ServiceException(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean makePayment(long cardNumber, int expirationMonth, int expirationYear, int cvv, double price) throws ServiceException {
        if (!isBankCardExist(cardNumber, expirationMonth, expirationYear, cvv)) {
            return false;
        }

        BankCardDao bankCardDao = DaoFactory.getInstance().getBankCardDao();
        try {
            Optional<BankCard> bankCard = bankCardDao.findByCardNumber(cardNumber);
            if (bankCard.isPresent()) {
                if (!isEnoughMoney(bankCard.get().getBalance(), price)) {
                    return false;
                }

                double newBalance = calculateNewBalance(bankCard.get().getBalance(), price);
                double scale = Math.pow(10, 2);
                newBalance = Math.ceil(newBalance * scale) / scale;
                bankCardDao.updateBalanceByCardNumber(cardNumber, newBalance);
                return true;
            }
            return false;
        } catch (DaoException e) {
            logger.error("Unable to pay by card!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private boolean isBankCardInformationCorrect(BankCard bankCard, long cardNumber, int expirationMonth, int expirationYear, int cvv) {
        if (bankCard.getCardNumber() != cardNumber) return false;
        if (bankCard.getExpirationMonth() != expirationMonth) return false;
        if (bankCard.getExpirationYear() != expirationYear) return false;
        if (bankCard.getCvv() != cvv) return false;
        return true;
    }

    private boolean isEnoughMoney(double balance, double price) {
        return price <= balance;
    }

    private double calculateNewBalance(double balance, double price) {
        return balance - price;
    }
}