package States;
import Farmer.Bob;
import Message.Message;

public class QuenchThirst implements State<Bob> {

    private static QuenchThirst instance = null;

    private QuenchThirst() {}

    public static QuenchThirst getInstance(){
        if (instance == null)
            instance = new QuenchThirst();
        return instance;
    }

    public void enter(Bob bob) {
        System.out.println(bob.getName() + " says: " + "Getting thirst out here... time to hit the bar!");
    }

    public void execute (Bob bob) {
        System.out.println(bob.getName() + " says: " + "Bring one more!!");

        bob.addThirst(-20);

        if (bob.isQuenched())
            bob.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
    }

    public void exit (Bob bob) {
        System.out.println(bob.getName() + " says: " + "Uff... I'm quenched! Back to work!");
    }

    @Override
    public boolean onMessage(Bob bob, Message msg) {
        return false;
    }
}
