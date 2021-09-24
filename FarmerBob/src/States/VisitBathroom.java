package States;

import Farmer.Farmer;
import Message.Message;

public class VisitBathroom implements State<Farmer>{

    private static VisitBathroom instance = null;

    private VisitBathroom(){}

    public static VisitBathroom getInstance(){
        if (instance == null)
            instance = new VisitBathroom();
        return instance;
    }

    @Override
    public void enter(Farmer f) {
        System.out.println(f.getName() + " says: " + "Bathroom Time!");
    }

    @Override
    public void execute(Farmer f) {
        System.out.println(f.getName() + " says: " + "I'm relieving now!");
        f.getStateMachine().revertToPreviousState();
    }

    @Override
    public void exit(Farmer f) {
        System.out.println(f.getName() + " says: " + "I think I'm done here!");
    }

    public boolean onMessage(Farmer f, Message msg) {
        return false;
    }
}
