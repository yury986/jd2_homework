package by.tomko;

import java.io.Serializable;

public class ExpensesDto implements Serializable {

    private final Integer paymentId;

    private final String date;

    private final Integer receiverId;

    private final Integer sum;


    public ExpensesDto(Integer paymentId, String date, Integer receiverId, Integer sum) {
        this.paymentId = paymentId;
        this.date = date;
        this.receiverId = receiverId;
        this.sum = sum;

    }
    public Integer getPaymentId() {
        return paymentId;
    }

    public String getDate() {
        return date;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public Integer getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "ExpensesDto{" +
                "paymentId=" + paymentId +
                ", date='" + date + '\'' +
                ", receiverId=" + receiverId +
                ", sum=" + sum +
                '}';
    }
}
