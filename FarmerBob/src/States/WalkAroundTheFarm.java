package States;

import Farmer.Farmer;

import java.util.Random;

public class WalkAroundTheFarm implements State {

    private static WalkAroundTheFarm instance = null;

    private WalkAroundTheFarm () { }

    public static WalkAroundTheFarm getInstance () {
        if (instance == null)
            instance = new WalkAroundTheFarm();
        return instance;
    }

    @Override
    public void enter(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Let's have a walk around");
    }

    @Override
    public void execute(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Walking, walking...");

        Random r = new Random();
        int rand = r.nextInt(4);
        if (rand <= 3)
            farmer.changeState(LookAtTheWeather.getInstance());
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "I am tired of walking");
    }
}
