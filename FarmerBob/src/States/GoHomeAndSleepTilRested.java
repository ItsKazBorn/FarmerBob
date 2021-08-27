package States;

import Farmer.Farmer;

public class GoHomeAndSleepTilRested implements State {
    public void enter(Farmer Farmer) {
        System.out.println("What a day! Time to hit the hay!");
    }

    public void execute (Farmer farmer) {

    }

    public void exit (Farmer farmer) {
        System.out.println("Rise and shine!");
    }
}
