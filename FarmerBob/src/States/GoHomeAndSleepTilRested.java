package States;

import Farmer.Farmer;

public class GoHomeAndSleepTilRested implements State {
    public void enter(Farmer Farmer) {
        System.out.println("What a day! Time to hit the hay!");
    }

    public void execute (Farmer farmer) {
        System.out.println("zzzzzzzzzz");

        farmer.addFatigue(-5);

        if(farmer.isRested())
            farmer.changeState(new EnterMineAndDigForNugget());
    }

    public void exit (Farmer farmer) {
        System.out.println("Rise and shine!");
    }
}
