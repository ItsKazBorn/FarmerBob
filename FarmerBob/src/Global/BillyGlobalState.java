package Global;

import Farmer.*;
import Message.Message;
import States.VisitBathroom;
import States.State;

import java.util.Random;

public class BillyGlobalState implements State<Farmer> {

    private static BillyGlobalState instance = null;

    private BillyGlobalState(){}

    public static BillyGlobalState getInstance(){
        if (instance == null)
            instance = new BillyGlobalState();
        return instance;
    }

    @Override
    public void enter(Farmer f) {

    }

    public void execute(Farmer f){
        Random r = new Random();
        int rand = r.nextInt(100);

        if (rand == 1)
            f.getStateMachine().changeState(VisitBathroom.getInstance());
    }

    @Override
    public void exit(Farmer f) {

    }

    @Override
    public boolean onMessage(Billy billy, Message msg) {
        if (msg.getMessage().compareTo("GetToWork!") == 0)
            billy.getStateMachine().changeState(FakeWork.getInstance());
            return true;
        else
            return false;
    }
}
