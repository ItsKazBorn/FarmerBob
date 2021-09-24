package Global;

import Farmer.Bob;
import Message.Message;
import States.State;
import States.VisitBathroom;

import java.util.Random;

public class BobGlobalState implements State<Bob> {

    private static BobGlobalState instance = null;

    private BobGlobalState(){}

    public static BobGlobalState getInstance(){
        if (instance == null)
            instance = new BobGlobalState();
        return instance;
    }

    @Override
    public void enter(Bob bob) {

    }

    public void execute(Bob bob){
        Random r = new Random();
        int rand = r.nextInt(100);

        if (rand == 1)
            bob.getStateMachine().changeState(VisitBathroom.getInstance());
    }

    @Override
    public void exit(Bob bob) {

    }

    @Override
    public boolean onMessage(Bob bob, Message msg) {
        if  (msg.getMessage().compareToIgnoreCase("JobsDone!")==0) {
            bob.setBillyWorked(true);
            return true;
        }
        return false;
    }
}
