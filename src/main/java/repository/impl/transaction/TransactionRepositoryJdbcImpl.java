package repository.impl.transaction;

import repository.Repository;
import config.DataBaseConnection;
import mapping.dtos.TransactionDTO;
import model.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransactionRepositoryJdbcImpl implements Repository <TransactionDTO> {
    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }
    private Transaction createTransaction(ResultSet resultSet) throws SQLException {
        Transaction transaction = new Transaction();

        return transaction;
    }
    @Override
    public List<TransactionDTO> list() {
        return null;
    }

    @Override
    public TransactionDTO byId(Integer id) {
        return null;
    }

    @Override
    public int save(TransactionDTO transactionDTO) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
