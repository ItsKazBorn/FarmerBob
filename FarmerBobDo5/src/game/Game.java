package game;

import States.GoHomeAndSleepTilRested;
import States.State;
import farmer.BaseFarmer;
import static java.lang.Thread.sleep;

public class Game {
    State currentState = new GoHomeAndSleepTilRested();
    public static void main(String[] args) {
        Game game = new Game();
        BaseFarmer baseFarmer = new BaseFarmer();
        try {
            game.playGame(baseFarmer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void playGame(BaseFarmer baseFarmer) throws InterruptedException {
        while (true){
            currentState = currentState.runState(baseFarmer);
        }
    }
}
