package Global;

import Farmer.*;
import Message.Message;
import States.VisitBathroom;
import States.State;

import java.util.Random;

public class BillyGlobalState implements State<Billy> {

    private static BillyGlobalState instance = null;

    private BillyGlobalState(){}

    public static BillyGlobalState getInstance(){
        if (instance == null)
            instance = new BillyGlobalState();
        return instance;
    }

    public void enter(Billy billy) {

    }

    public void execute(Billy billy) {
        Random r = new Random();
        int rand = r.nextInt(100);

        if (rand == 1)
            billy.getStateMachine().changeState(VisitBathroom.getInstance());
    }

    public void exit(Billy f) {

    }

    public boolean onMessage(Billy billy, Message msg) {
        if (msg.getMessage().compareTo("GetToWork!") == 0)
            billy.getStateMachine().changeState(FakeWork.getInstance());
            return true;
        else
            return false;
    }
}
