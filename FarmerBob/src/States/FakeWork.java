package States;

import Farmer.Billy;
import Message.Message;

public class FakeWork implements State<Billy>{

    private static FakeWork intance = null;

    private FakeWork() {}

    public static FakeWork getInstance(){
        if (intance == null)
            intance = new FakeWork();
        return intance;
    }

    public void enter(Billy f) {

    }


    public void execute(Billy f) {

    }


    public void exit(Billy f) {

    }


    public boolean onMessage(Billy f, Message msg) {
        return false;
    }
}
