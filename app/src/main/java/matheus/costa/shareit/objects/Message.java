package matheus.costa.shareit.objects;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by Matheus on 23/10/2017.
 */

public class Message implements Serializable, Comparable<Message> {

    private String messageUserId; //author
    private String messageId;
    private String messageContent; //content
    private int messageRate; //number of user that like the message
    private List<String> messageRateUsersId; //id of users that like the message
    private String messageTimeStamp;

    public Message() {
        messageRateUsersId = new ArrayList<>();
        this.messageRate = messageRateUsersId.size();
    }

    public List<String> getMessageRateUsersId() {
        return messageRateUsersId;
    }

    public Message setMessageRateUsersId(List<String> messageRateUsersId) {
        this.messageRateUsersId = messageRateUsersId;
        return this;
    }

    public String getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public Message setMessageTimeStamp(String messageTimeStamp) {
        this.messageTimeStamp = messageTimeStamp;
        return this;
    }

    public String getMessageUserId() {
        return messageUserId;
    }

    public Message setMessageUserId(String messageUserId) {
        this.messageUserId = messageUserId;
        return this;
    }

    public String getMessageId() {
        return messageId;
    }

    public Message setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public Message setMessageContent(String messageContent) {
        this.messageContent = messageContent;
        return this;
    }

    public int getMessageRate() {
        return messageRate;
    }

    public Message setMessageRate(int messageRate) {
        this.messageRate = messageRate;
        return this;
    }

    public void userRate(String userUid){
        if (this.messageRateUsersId.contains(userUid)){
            //If user already rate up the message and clicked again
            this.messageRateUsersId.remove(userUid);
            this.messageRate = this.messageRateUsersId.size();
        }else{
            this.messageRateUsersId.add(userUid);
            this.messageRate = this.messageRateUsersId.size();
        }
    }


    @Override
    public int compareTo(@NonNull Message o) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        try {
            Date date1 = sdf.parse(this.messageTimeStamp);
            Date date2 = sdf.parse(o.messageTimeStamp);
            return date1.compareTo(date2);

            /*
            switch (date1.compareTo(date2)){
                case -1:
                    return 1;
                case 1:
                    return -1;
                default:
                    return 0;
            }
*/
        } catch (Throwable t) {
            Log.e("Message","compareTo() ERROR!",t);
        }
        return 0;
    }
}
