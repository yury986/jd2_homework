package by.tomko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarDataSource {


        private static CarDataSource dataSource;
        protected CarDataSource() throws ClassNotFoundException {
            // Load JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        }

        protected Connection getCarConnection() throws SQLException {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/task1-2",
                    "root",
                    "root");
        }

        public static Connection getConnection() throws ClassNotFoundException, SQLException {
            if (dataSource == null) {
                dataSource = new CarDataSource();
            }
            return dataSource.getCarConnection();
        }

}
