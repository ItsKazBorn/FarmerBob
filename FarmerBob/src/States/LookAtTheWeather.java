package States;
import Farmer.*;
import java.util.Random;

public class LookAtTheWeather implements State<Bob> {

    private static LookAtTheWeather instance = null;

    private LookAtTheWeather() { }

    public static LookAtTheWeather getInstance() {
        if (instance == null)
            instance = new LookAtTheWeather();
        return instance;
    }

    @Override
    public void enter(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Time to rest and look at the sky...");
    }

    @Override
    public void execute(Billy billy) {
        System.out.println(billy.getName() + " says: " + "The sky is pretty today!");

        Random r = new Random();
        int rand = r.nextInt(4);
        if (rand == 1)
            billy.getStateMachine().changeState(WalkAroundTheFarm.getInstance());
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "That's enough looking for now");
    }
}
