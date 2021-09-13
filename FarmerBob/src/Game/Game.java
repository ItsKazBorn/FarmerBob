package Game;

import Farmer.Farmer;
import States.GoHomeAndSleepTilRested;
import States.WalkAroundTheFarm;

import java.util.ArrayList;

public class Game {

    private static int move = 1;

    public static void main(String[] args) {
        Game game = new Game();
        Farmer bob = new Farmer("Bob", GoHomeAndSleepTilRested.getInstance());
        Farmer billy = new Farmer("Billy", WalkAroundTheFarm.getInstance());

        ArrayList<Farmer> farmers = new ArrayList();
        farmers.add(bob);
        farmers.add(billy);

        while (true) {
            System.out.println("===================" + "MOVE: " + move + "=====================");
            for (int i = 0; i < farmers.size(); i++) {
                Farmer farmer = farmers.get(i);
                game.playGame(farmer);
            }
            move++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void playGame (Farmer farmer) {
            farmer.runCurrentState();
    }

}
