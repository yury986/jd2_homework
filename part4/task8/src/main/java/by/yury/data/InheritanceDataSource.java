package by.yury.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InheritanceDataSource {

    private static InheritanceDataSource dataSource;
    protected InheritanceDataSource() throws ClassNotFoundException {
        // Load JDBC driver for MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getInheritanceConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/task8",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new InheritanceDataSource();
        }
        return dataSource.getInheritanceConnection();
    }
}
