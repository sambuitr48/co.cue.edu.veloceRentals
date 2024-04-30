package Repository.impl;

import Repository.Repository;
import config.DataBaseConnection;
import mapping.dtos.ReservationDTO;
import model.Reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.User;

public class ReservationRepositoryJdbcImpl implements Repository<ReservationDTO> {
    private Connection getConnection() throws SQLException{
        return DataBaseConnection.getInstance();
    }
    private ReservationDTO createReservation(ResultSet resultSet) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setReservation_id(resultSet.getInt("reservation_id"));
    }
    @Override
    public List<ReservationDTO> list() {
        return null;
    }

    @Override
    public ReservationDTO byId(Integer id) {
        return null;
    }

    @Override
    public int save(ReservationDTO reservationDTO) {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }
}
