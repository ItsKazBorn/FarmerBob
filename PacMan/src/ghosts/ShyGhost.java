package ghosts;

import pacman.*;
import util.Utils;

import java.awt.*;
import java.util.List;
import java.util.Vector;


public class ShyGhost extends GhostPlayer {

    //CHASE
    public Move chooseMove(Game game, int ghostIndex) {
        ConfigureColor(Color.RED);

        State state = game.getCurrentState();
        Location pacManLocation = state.getPacManLocation();
        Location ghostLocation = state.getGhostLocations().get(ghostIndex);
        List<Move> moves = game.getLegalGhostMoves(ghostIndex);

        //PETRIFY
        if (pacManLocation.getX() == ghostLocation.getX() || pacManLocation.getY() == ghostLocation.getY()){
            ConfigureColor(Color.YELLOW);
            return Move.NONE;
        }

        if (moves.isEmpty()) return Move.NONE;
        double[] distances = new double[moves.size()];
        for (int i=0; i<distances.length; i++) {
            Location newLoc = Game.getNextLocation(state.getGhostLocations().get(ghostIndex), moves.get(i));
            distances[i] = Location.euclideanDistance(pacManLocation, newLoc);
        }
        int moveIndex = Utils.argmin(distances);
        return moves.get(moveIndex);
    }

    private void ConfigureColor (Color color) {
        if (getColor() != color) {
            setColor(color);
        }
    }
}
