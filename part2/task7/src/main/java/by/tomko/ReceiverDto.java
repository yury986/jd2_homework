package by.tomko;

import java.io.Serializable;

public class ReceiverDto implements Serializable {

    private final Integer receiverId;

    private final String receiverName;


    public ReceiverDto(Integer receiverId, String receiverName) {
        this.receiverId = receiverId;
        this.receiverName = receiverName;


    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    @Override
    public String toString() {
        return "ReceiverDto{" +
                "receiverId=" + receiverId +
                ", receiverName='" + receiverName + '\'' +
                '}';
    }
}
