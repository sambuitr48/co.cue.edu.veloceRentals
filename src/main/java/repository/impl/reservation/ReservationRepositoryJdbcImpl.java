package repository.impl.reservation;

import repository.Repository;
import config.DataBaseConnection;
import mapping.dtos.ReservationDTO;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationRepositoryJdbcImpl implements Repository<ReservationDTO> {
    private Connection getConnection() throws SQLException{
        return DataBaseConnection.getInstance();
    }

    private Reservation createReservation(ResultSet resultSet) throws SQLException {
         Reservation reservation = new Reservation();

         return reservation;
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
    public void delete(int id) {

    }
}
