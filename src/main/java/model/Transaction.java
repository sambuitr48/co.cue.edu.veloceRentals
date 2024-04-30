package model;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Transaction {
    private int transaction_id;
    private User user;
    private Reservation reservation;
    private Double total_price;
    private String state;
}
