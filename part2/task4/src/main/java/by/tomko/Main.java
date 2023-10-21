package by.tomko;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        int idMain = Integer.parseInt(args[0]);
        String dateMain = args[1];
        String recipientMain = args[2];
        int sumMain = Integer.parseInt(args[3]);

        //language=MySQL
        String insertQuery =  "insert into expenses (id,date,recipient,sum) values('"+idMain+"','"+dateMain+"','"+recipientMain+"','"+sumMain+"')";


        Statement statement = ExpensesDataSource.getConnection().createStatement();
        statement.executeUpdate(insertQuery);

        String selectQery = "select * from expenses";
        ResultSet resultSet = statement.executeQuery(selectQery);
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String date = resultSet.getString("date");
            String recipient = resultSet.getString("recipient");
            int sum = resultSet.getInt("sum");
            System.out.println("Id:" + id + " " + "Date:" + date + " " + "Recipient:" + recipient + " " + "Sum:" + sum);

        }
        resultSet.close();
        statement.close();

    }
}
