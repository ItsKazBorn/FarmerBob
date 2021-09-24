package States;
import Farmer.*;
import Message.Message;
import Message.MessageDispatcher;

public class GoHomeAndSleepTilRested implements State<Bob> {

    private static GoHomeAndSleepTilRested instance = null;

    private GoHomeAndSleepTilRested() {}

    public static GoHomeAndSleepTilRested getInstance(){
        if (instance == null)
            instance = new GoHomeAndSleepTilRested();
        return instance;
    }

    public void enter(Bob bob) {
        bob.setLocation("Farm");
        bob.setBillyWorked(false);

        Entity billy = EntityManager.getInstance().getEntity("Billy");
        MessageDispatcher.getInstance().dispatchMessage(bob, billy, "GetToWork!", null);
    }

    public void execute (Bob bob) {
        System.out.println(bob.getName() + " says: " + "zzzzzzzzzz");

        bob.addFatigue(-5);

        if(bob.billyWorked() && bob.isRested())
            bob.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
        else if (bob.isRested())
            System.out.println("Waiting this goddamn brother to finish his work...");
    }

    public void exit (Bob bob) {
        System.out.println(bob.getName() + " says: " + "Rise and shine!");
    }

    public boolean onMessage(Bob bob, Message msg) {
        return false;
    }
}
