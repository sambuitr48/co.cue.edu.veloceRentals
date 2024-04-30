package mapping.dtos;

import lombok.Builder;
import model.Reservation;
import model.User;
@Builder
public record TransactionDTO(int transaction_id,
                             User user,
                             Reservation reservation,
                             Double total_price,
                             String state) {
}
