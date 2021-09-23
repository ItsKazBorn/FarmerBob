package States;

import Farmer.Farmer;
import Message.Message;

public interface State<NPC> {
    public void enter (NPC f);

    public void execute(NPC f);

    public void exit (NPC f);

    public boolean onMessage(NPC f, Message msg);
}
