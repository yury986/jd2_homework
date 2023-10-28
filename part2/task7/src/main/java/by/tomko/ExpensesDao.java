package by.tomko;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDao {

    public ReceiverDto getReceiver (int num) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = ExpensesDataSource.getConnection()
                .prepareStatement("select * from receivers where receiver_id = ?");
        preparedStatement.setInt(1,num);
        ResultSet resultSet = preparedStatement.executeQuery();
        ReceiverDto receiverDto = null;
        if (resultSet.next()){
            receiverDto = new ReceiverDto(resultSet.getInt("receiver_id"),
                                          resultSet.getString("receiver_name"));
        }
        preparedStatement.close();
        resultSet.close();
        return receiverDto;
    }
    public ExpensesDto getExpenses (int num) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = ExpensesDataSource.getConnection()
                .prepareStatement("select * from expenses where payment_id = ?");
        preparedStatement.setInt(1,num);
        ResultSet resultSet = preparedStatement.executeQuery();
        ExpensesDto expensesDto = null;
        if (resultSet.next()){
            expensesDto = new ExpensesDto(resultSet.getInt("payment_id"),
                    resultSet.getString("date"),
                    resultSet.getInt("receiver_id"),
                    resultSet.getInt("sum")
            );
        }
        preparedStatement.close();
        resultSet.close();
        return expensesDto;
    }

    public List<ReceiverDto> getReceivers() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = ExpensesDataSource.getConnection().prepareStatement("select * from receivers");
        List<ReceiverDto> receivers = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            receivers.add(new ReceiverDto(resultSet.getInt("receiver_id"),
                                     resultSet.getString("receiver_name")));
        }
        preparedStatement.close();
        resultSet.close();
        return receivers;
    }

    public List<ExpensesDto> getExpenses() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = ExpensesDataSource.getConnection().prepareStatement("select * from expenses");
        List<ExpensesDto> expenses = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            expenses.add(new ExpensesDto(resultSet.getInt("payment_id"),
                    resultSet.getString("date"),
                    resultSet.getInt("receiver_id"),
                    resultSet.getInt("sum")));
        }
        preparedStatement.close();
        resultSet.close();
        return expenses;
    }

    public ReceiverDto addReceiver (ReceiverDto receiverDto) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = ExpensesDataSource.getConnection().prepareStatement("insert into receivers(receiver_id,receiver_name)  values(?,?)");
        preparedStatement.setInt(1,receiverDto.getReceiverId());
        preparedStatement.setString(2, receiverDto.getReceiverName());

        preparedStatement.executeUpdate();
        return receiverDto;
    }

    public ExpensesDto addExpenses (ExpensesDto expensesDto) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = ExpensesDataSource.getConnection().prepareStatement("insert into expenses(payment_id,date,receiver_id,sum)  values(?,?,?,?)");
        preparedStatement.setInt(1,expensesDto.getPaymentId());
        preparedStatement.setString(2, expensesDto.getDate());
        preparedStatement.setInt(3,expensesDto.getReceiverId());
        preparedStatement.setInt(4,expensesDto.getSum());

        preparedStatement.executeUpdate();
        return expensesDto;
    }

}
