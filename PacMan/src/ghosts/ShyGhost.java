package ghosts;

import pacman.*;
import util.Utils;

import java.util.List;
import java.util.Vector;

public class ShyGhost extends GhostPlayer {

    //CHASE
    public Move chooseMove(Game game, int ghostIndex) {
        State state = game.getCurrentState();
        Location pacManLocation = state.getPacManLocation();
        Location ghostLocation = state.getGhostLocations().get(ghostIndex);
        List<Move> moves = game.getLegalGhostMoves(ghostIndex);

        if (pacManLocation.getX() == ghostLocation.getX() || pacManLocation.getY() == ghostLocation.getY()){
            return Move.NONE;
        }

        if (moves.isEmpty()) return Move.NONE;
        double[] distances = new double[moves.size()];
        Location pacManLoc = state.getPacManLocation();
        for (int i=0; i<distances.length; i++) {
            Location newLoc = Game.getNextLocation(state.getGhostLocations().get(ghostIndex), moves.get(i));
            System.out.println("Current Location: " + newLoc);
            distances[i] = Location.euclideanDistance(pacManLoc, newLoc);
        }
        int moveIndex = Utils.argmin(distances); // the move that minimizes the distance to PacMan
        return moves.get(moveIndex);
    }
}
