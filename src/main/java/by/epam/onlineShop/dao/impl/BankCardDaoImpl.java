package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.BankCardDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.BankCard;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public class BankCardDaoImpl extends AbstractDao<BankCard> implements BankCardDao {

    private static final String FIND_BANK_CARD_BY_NUMBER_QUERY = "SELECT * FROM " + Table.BANK_CARD + " WHERE card_number=?";
    private static final String SAVE_BANK_CARD_QUERY = "INSERT INTO " + Table.BANK_CARD +
            " (card_number, expiration_year, expiration_month, card_owner, balance, cvv) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_BALANCE_BY_CARD_NUMBER_QUERY = "UPDATE " + Table.BANK_CARD + " SET balance=? WHERE card_number=?";

    public BankCardDaoImpl() {
        super(RowMapperFactory.getInstance().getBankCardRowMapper(), Table.BANK_CARD);
    }

    @Override
    public Optional<BankCard> findByCardNumber(long cardNumber) throws DaoException {
        return executeQueryForSingleResult(FIND_BANK_CARD_BY_NUMBER_QUERY, cardNumber);
    }

    @Override
    public void updateBalanceByCardNumber(long cardNumber, double newBalance) throws DaoException {
        executeUpdateQuery(UPDATE_BALANCE_BY_CARD_NUMBER_QUERY, newBalance, cardNumber);
    }

    @Override
    public long save(BankCard bankCard) throws DaoException {
        return executeInsertQuery(SAVE_BANK_CARD_QUERY, bankCard.getCardNumber(), bankCard.getExpirationYear(),
                bankCard.getExpirationMonth(), bankCard.getCardholderName(), bankCard.getBalance(), bankCard.getCvv());
    }
}
