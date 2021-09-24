package States;
import Farmer.Bob;
import Message.Message;

import java.util.Random;

public class EnterMineAndDigForNugget implements State<Bob> {

    private static EnterMineAndDigForNugget instance = null;

    private EnterMineAndDigForNugget() {}

    public static EnterMineAndDigForNugget getInstance(){
        if (instance == null)
            instance = new EnterMineAndDigForNugget();
        return instance;
    }

    public void enter(Bob bob) {
        System.out.println(bob.getName() + " says: " + "Let's go mine");
    }

    public void execute (Bob bob) {
        System.out.println(bob.getName() + " says: " + "Mining away!");

        // Mine
        Random r = new Random();
        int rand = r.nextInt(3);
        if (rand == 1) {
            System.out.println(bob.getName() + " says: " + "A gold nugget! So shiny!");
            bob.addNugget(1);
        }

        // Gain Stats
        bob.addFatigue(5);
        bob.addThirst(5);

        // Check for New State
        if (bob.isPocketFull() || bob.isTired())
            bob.getStateMachine().changeState(VisitBankAndDepositGold.getInstance());

        if (bob.isThirsty())
            bob.getStateMachine().changeState(QuenchThirst.getInstance());
    }

    public void exit (Bob bob) {
        System.out.println(bob.getName() + " says: " + "That's all for now...");
    }

    @Override
    public boolean onMessage(Bob bob, Message msg) {
        return false;
    }
}
