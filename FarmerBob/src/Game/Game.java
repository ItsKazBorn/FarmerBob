package Game;

import Farmer.Farmer;
import States.GoHomeAndSleepTilRested;
import States.WalkAroundTheFarm;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        Farmer bob = new Farmer("Bob", new GoHomeAndSleepTilRested());
        Farmer billy = new Farmer("Billy", new WalkAroundTheFarm());

        ArrayList<Farmer> farmers = new ArrayList();
        farmers.add(bob);
        farmers.add(billy);

        while (true) {
            for (int i = 0; i < farmers.size(); i++) {
                Farmer farmer = farmers.get(i);
                game.playGame(farmer);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void playGame (Farmer farmer) {
            farmer.runCurrentState();
    }

}
