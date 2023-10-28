package by.tomko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExpensesDataSource {
    private  static ExpensesDataSource dataSource;
    public ExpensesDataSource () throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    private Connection getExpensesDataSource  () throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/task7",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if (dataSource == null){
            dataSource = new ExpensesDataSource();
        }
        return dataSource.getExpensesDataSource();
    }


}
