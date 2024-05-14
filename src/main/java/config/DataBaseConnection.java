    package config;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class DataBaseConnection {
        private static String url = "jdbc:mysql://localhost:3306/velocerentals";
        private static String user = "root";
        private static String password ="";
        private static Connection connection;

        public DataBaseConnection() {
        }

        public static Connection getInstance() throws SQLException{
            if(connection == null || connection.isClosed()){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, user, password);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return connection;
        }
    }
