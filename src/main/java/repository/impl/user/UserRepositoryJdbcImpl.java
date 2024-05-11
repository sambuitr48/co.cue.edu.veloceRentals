package repository.impl.user;

import config.DataBaseConnection;
import model.User;
import repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJdbcImpl implements Repository<User> {

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }
    private User createUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setName(resultSet.getString("name"));
        user.setMail(resultSet.getString("mail"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
    @Override
    public List<User> list() {
        List<User> userList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                         SELECT *
                         FROM users
                         """
             )
        ){
           while (resultSet.next()){
               User user = createUser(resultSet);
               userList.add(user);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User byId(Integer id) {
        User user = null;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                """
                    SELECT * 
                    FROM users
                    WHERE id = ? 
                    """
        ))
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user = createUser(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int save(User user) {
        int idGenerator = 0;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                """
                    INSERT INTO users (name, email, password)
                    VALUES (?,?,?)
                    """, Statement.RETURN_GENERATED_KEYS
        ))
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getMail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                idGenerator = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGenerator;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                """
                    DELETE * 
                    FROM users
                    WHERE id = ?
                    """
        )){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
