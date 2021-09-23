package States;
import Farmer.Farmer;

public class QuenchThirst implements State<Farmer> {

    private static QuenchThirst instance = null;

    private QuenchThirst() {}

    public static QuenchThirst getInstance(){
        if (instance == null)
            instance = new QuenchThirst();
        return instance;
    }

    public void enter(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Getting thirst out here... time to hit the bar!");
    }

    public void execute (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Bring one more!!");

        farmer.addThirst(-20);

        if (farmer.isQuenched())
            farmer.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
    }

    public void exit (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Uff... I'm quenched! Back to work!");
    }
}
