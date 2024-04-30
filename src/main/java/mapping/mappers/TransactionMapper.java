package mapping.mappers;

import mapping.dtos.TransactionDTO;
import model.Transaction;

public class TransactionMapper {
    public static Transaction mapFrom(TransactionDTO transactionDTO){
        return Transaction.builder()
                .transaction_id(transactionDTO.transaction_id())
                .user(transactionDTO.user())
                .reservation(transactionDTO.reservation())
                .total_price(transactionDTO.total_price())
                .state(transactionDTO.state())
                .build();
    }
    public static TransactionDTO mapFrom(Transaction transaction){
        return TransactionDTO.builder()
                .transaction_id(transaction.getTransaction_id())
                .user(transaction.getUser())
                .reservation(transaction.getReservation())
                .total_price(transaction.getTotal_price())
                .state(transaction.getState())
                .build();
    }
}
