package States;

import Farmer.Farmer;

import java.util.Random;

public class LookAtTheWeather implements State {

    @Override
    public void enter(Farmer farmer) {
        System.out.println("Time to rest and look at the sky...");
    }

    @Override
    public void execute(Farmer farmer) {
        System.out.println("The sky is pretty today!");

        Random r = new Random();
        int rand = r.nextInt(4);
        if (rand == 1)
            farmer.changeState(new WalkAroundTheFarm());
    }

    @Override
    public void exit(Farmer farmer) {
        System.out.println("That's enough looking for now");
    }
}
