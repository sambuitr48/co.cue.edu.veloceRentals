package mapping.mappers;

import mapping.dtos.ReservationDTO;
import model.Reservation;

public class ReservationMapper {
    public static Reservation mapFrom(ReservationDTO reservationDTO){
        return Reservation.builder()
                .reservation_id(reservationDTO.reservation_id())
                .user(reservationDTO.user())
                .start_date(reservationDTO.start_date())
                .finish_date(reservationDTO.finish_date())
                .state(reservationDTO.state())
                .build();
    }
    public static ReservationDTO mapFrom(Reservation reservation){
        return ReservationDTO.builder()
                .reservation_id(reservation.getReservation_id())
                .user(reservation.getUser())
                .start_date(reservation.getStart_date())
                .finish_date(reservation.getFinish_date())
                .state(reservation.getState())
                .build();
    }
}
