package States;
import Farmer.Farmer;
import java.util.Random;

public class EnterMineAndDigForNugget implements State<Farmer> {

    private static EnterMineAndDigForNugget instance = null;

    private EnterMineAndDigForNugget() {}

    public static EnterMineAndDigForNugget getInstance(){
        if (instance == null)
            instance = new EnterMineAndDigForNugget();
        return instance;
    }

    public void enter(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Let's go mine");
    }

    public void execute (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Mining away!");

        // Mine
        Random r = new Random();
        int rand = r.nextInt(3);
        if (rand == 1) {
            System.out.println(farmer.getName() + " says: " + "A gold nugget! So shiny!");
            farmer.addNugget(1);
        }

        // Gain Stats
        farmer.addFatigue(5);
        farmer.addThirst(5);

        // Check for New State
        if (farmer.isPocketFull() || farmer.isTired())
            farmer.getStateMachine().changeState(VisitBankAndDepositGold.getInstance());

        if (farmer.isThirsty())
            farmer.getStateMachine().changeState(QuenchThirst.getInstance());
    }

    public void exit (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "That's all for now...");
    }
}
