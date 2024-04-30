package mapping.dtos;

import lombok.Builder;
import model.User;
import model.Vehicle;

import java.time.LocalDate;

@Builder
public record ReservationDTO(int reservation_id,
                             User user,
                             Vehicle vehicle,
                             LocalDate start_date,
                             LocalDate finish_date,
                             String state) {
}
