package States;
import Farmer.Farmer;

public class QuenchThirst implements State<Farmer> {
    public void enter(Farmer Farmer) {
        System.out.println("Getting thirst out here... time to hit the bar!");
    }

    public void execute (Farmer farmer) {
        System.out.println("Bring one more!!");

        farmer.addThirst(-20);

        if (farmer.isQuenched())
            farmer.changeState(new EnterMineAndDigForNugget());
    }

    public void exit (Farmer farmer) {
        System.out.println("Uff... I'm quenched! Back to work!");
    }
}
