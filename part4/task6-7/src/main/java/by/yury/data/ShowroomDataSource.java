package by.yury.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShowroomDataSource {

    private static ShowroomDataSource dataSource;
    protected ShowroomDataSource() throws ClassNotFoundException {
        // Load JDBC driver for MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getShowroomConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/task6-7",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new ShowroomDataSource();
        }
        return dataSource.getShowroomConnection();
    }

}
