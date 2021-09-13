package States;

import Farmer.Farmer;

public class GoHomeAndSleepTilRested implements State {

    private static GoHomeAndSleepTilRested instance = null;

    private GoHomeAndSleepTilRested() {}

    public static GoHomeAndSleepTilRested getInstance(){
        if (instance == null)
            instance = new GoHomeAndSleepTilRested();
        return instance;
    }

    public void enter(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "What a day! Time to hit the hay!");
    }

    public void execute (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "zzzzzzzzzz");

        farmer.addFatigue(-5);

        if(farmer.isRested())
            farmer.changeState(EnterMineAndDigForNugget.getInstance());
    }

    public void exit (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Rise and shine!");
    }
}
