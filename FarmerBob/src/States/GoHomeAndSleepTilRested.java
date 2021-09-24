package States;
import Farmer.*;
import Message.Message;
import Message.MessageDispatcher;

public class GoHomeAndSleepTilRested implements State<Farmer> {

    private static GoHomeAndSleepTilRested instance = null;

    private GoHomeAndSleepTilRested() {}

    public static GoHomeAndSleepTilRested getInstance(){
        if (instance == null)
            instance = new GoHomeAndSleepTilRested();
        return instance;
    }

    public void enter(Bob bob) {
        //bob.setLocation("Farm");
        //bob.setBillyWorked(false);

        Entity billy = EntityManager.getInstance().getEntity("Billy");
        MessageDispatcher.getInstance().dispatchMessage(bob, billy, "GetToWork!", null);
    }

    public void enter(Farmer f) {

    }

    public void execute (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "zzzzzzzzzz");

        farmer.addFatigue(-5);

        if(farmer.isRested())
            farmer.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
    }

    public void exit (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Rise and shine!");
    }

    public boolean onMessage(Farmer farmer, Message msg) {
        return false;
    }
}
