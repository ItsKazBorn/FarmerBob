package Game;

import Farmer.Farmer;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        Farmer bob = new Farmer();
        game.playGame(bob);
    }

    public void playGame (Farmer farmer) {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            farmer.runCurrentState();
        }
    }
}
