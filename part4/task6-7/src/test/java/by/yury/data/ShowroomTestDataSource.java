package by.yury.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShowroomTestDataSource extends ShowroomDataSource {

    private static ShowroomTestDataSource dataSource;

    protected ShowroomTestDataSource() throws ClassNotFoundException {
        super();
    }

    @Override
    protected Connection getShowroomConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/task6-7_test",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new ShowroomTestDataSource();
        }
        return dataSource.getShowroomConnection();
    }


}
