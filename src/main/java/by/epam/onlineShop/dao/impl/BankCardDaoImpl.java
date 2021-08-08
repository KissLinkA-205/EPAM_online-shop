package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.BankCardDao;
import by.epam.onlineShop.entity.BankCard;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public class BankCardDaoImpl implements BankCardDao {

    @Override
    public Optional<BankCard> findByCardNumber(long cardNumber) throws DaoException {
        return Optional.empty();
    }
}
