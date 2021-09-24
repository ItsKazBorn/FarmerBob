package States;
import Farmer.Bob;
import Message.Message;

public class VisitBankAndDepositGold implements State<Bob> {

    private static VisitBankAndDepositGold instance = null;

    private VisitBankAndDepositGold() {}

    public static VisitBankAndDepositGold getInstance(){
        if (instance == null)
            instance = new VisitBankAndDepositGold();
        return instance;
    }

    public void enter(Bob bob) {
        System.out.println(bob.getName() + " says: " + "Let's save these nuggets in the bank...");
    }

    public void execute (Bob bob) {
        System.out.println(bob.getName() + " says: " + "Today I deposited " + bob.getPocketMoney() + " nuggets");
        bob.depositGold();

        if (bob.isTired())
            bob.getStateMachine().changeState(GoHomeAndSleepTilRested.getInstance());
        else
            bob.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
    }

    public void exit (Bob bob) {
        System.out.println(bob.getName() + " says: " + "Thanks again for keeping my gold safe!");
    }


    public boolean onMessage(Bob bob, Message msg) {
        return false;
    }
}
