package States;

import Farmer.Farmer;

import java.util.Random;

public class WalkAroundTheFarm implements State {

    @Override
    public void enter(Farmer farmer) {
        System.out.println("Let's have a walk around");
    }

    @Override
    public void execute(Farmer farmer) {
        System.out.println("Walking, walking...");

        Random r = new Random();
        int rand = r.nextInt(4);
        if (rand <= 3)
            farmer.changeState(new LookAtTheWeather());
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println("I am tired of walking");
    }
}
