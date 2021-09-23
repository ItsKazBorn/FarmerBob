package Global;

import Farmer.Farmer;
import States.State;
import States.VisitBathroom;

import java.util.Random;

public class BobGlobalState implements State<Farmer> {

    private static BobGlobalState instance = null;

    private BobGlobalState(){}

    public static BobGlobalState getInstance(){
        if (instance == null)
            instance = new BobGlobalState();
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
}
