package by.tomko;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ExpensesDao expensesDao = new ExpensesDao();

        System.out.println(expensesDao.getReceiver(2));
        System.out.println(expensesDao.getExpenses(4));
        System.out.println();

        System.out.println(expensesDao.getReceivers());
        System.out.println(expensesDao.getExpenses());
        System.out.println();

        ReceiverDto receiverDto = new ReceiverDto(6,"Cosmos");
        expensesDao.addReceiver(receiverDto);


        ExpensesDto expensesDto = new ExpensesDto(15,"11.06.2011",2,12000);
        expensesDao.addExpenses(expensesDto);
    }
}
