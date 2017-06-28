package p02WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private Importance impLevel;
    private List<Message> messages;

    public Logger(Importance impLevel) {
        this.impLevel = impLevel;
        this.messages=new ArrayList<>();
    }

    public void add(Message message){
        if (message.getImpLevel().compareTo(this.impLevel)>=0){
            this.messages.add(message);
        }
    }

    Iterable<Message> getMessages(){
        return this.messages;
    }
}
