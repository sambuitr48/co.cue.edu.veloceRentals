package model;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Reservation {
    private int reservation_id;
    private User user;
    private Vehicle vehicle;
    private LocalDate start_date;
    private LocalDate finish_date;
}
