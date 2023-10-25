package by.tomko;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Statement statement = ExpensesDataSource.getConnection().createStatement();

    String sumPaymentRecipients = "SELECT recipient_name,  sum(sum) FROM recipients JOIN expenses e on recipients.recipient_id = e.recipient_id GROUP BY recipient_name";

    ResultSet resultsumPaymentRecipients = statement.executeQuery(sumPaymentRecipients);
    while (resultsumPaymentRecipients.next()) {
        String recipient = resultsumPaymentRecipients.getString("recipient_name");
        int sum = resultsumPaymentRecipients.getInt("sum(sum)");
        System.out.println("Recipient:" + recipient + " " + "Sum:" + sum);
    }
        resultsumPaymentRecipients.close();

    String sumPayment = "select sum(sum) from expenses where date = (select  date from expenses group by date order by max(sum) desc limit 0,1 )";

    ResultSet sumPaymentOfDay = statement.executeQuery(sumPayment);
        while (sumPaymentOfDay.next()) {
            int sumSum = sumPaymentOfDay.getInt("sum(sum)");
            System.out.println( "Sum Payment Of the day:" + sumSum);

        }
        sumPaymentOfDay.close();


    String maxPayment = "select max(sum) from expenses where date = (select date from expenses group by date order by sum(sum) desc limit 0, 1)";

        ResultSet maxPaymentOfDay = statement.executeQuery(maxPayment);
        while (maxPaymentOfDay.next()) {
            int maxSum = maxPaymentOfDay.getInt("max(sum)");
            System.out.println( "Max Payment Of the day:" + maxSum);

        }
        maxPaymentOfDay.close();
        statement.close();

}
}
