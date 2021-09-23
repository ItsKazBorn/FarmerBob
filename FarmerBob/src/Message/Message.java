package Message;

import Farmer.Entity;

public class Message {

    private Entity sender;

    private Entity receiver;

    private String message;

    private Object extraInfo;

    public  Message(Entity msgSender, Entity msgReceiver, String message, Object extraInfo) {
        this.sender = msgSender;
        this.receiver = msgReceiver;
        this.message = message;
        this.extraInfo = extraInfo;
    }

    public String getMessage () {
        return message;
    }
}
