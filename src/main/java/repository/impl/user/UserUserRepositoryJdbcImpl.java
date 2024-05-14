package repository.impl.user;

import annotations.Mysqlconn;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.User;
import repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class UserUserRepositoryJdbcImpl implements UserRepository<User> {
    @Inject
    @Mysqlconn
    private Connection conn;

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
        try (Statement statement = conn.createStatement();
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
    public User verifyExist(String mail, String password) {

        User user = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                """
                    SELECT *
                    FROM users
                    WHERE mail = ? and password = ?
                    """
        ))
        {
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, password);
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
    public void save(User user) {
        int idGenerator = 0;
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                """
                    INSERT INTO users (name, email, password, mobile)
                    VALUES (?,?,?,?)
                    """, Statement.RETURN_GENERATED_KEYS
        ))
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getMail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getMobile());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                idGenerator = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                """
                    DELETE  
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
