package by.yury.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InheritanceTestDataSource {

    private static InheritanceTestDataSource dataSource;

    protected InheritanceTestDataSource() throws ClassNotFoundException {
        super();
    }

    protected Connection getInheritanceConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/task8_test",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new InheritanceTestDataSource();
        }
        return dataSource.getInheritanceConnection();
    }

}
