package ghosts;

import pacman.*;

import java.awt.*;
import java.util.List;

public class DasherGhost extends GhostPlayer {

    private Location target = null;
    private Move lastMove = null;

    private boolean isDashing = false;

    @Override
    public Move chooseMove(Game game, int ghostIndex) {
        ConfigureColor(Color.cyan);

        State state = game.getCurrentState();

        if (!isDashing) {
            target = getTarget(state);
            Location oldLoc = state.getGhostLocations().get(ghostIndex);
            isDashing = true;
            return chooseBestMove(game, ghostIndex, oldLoc);
        }
        else {
            List<Move> legalMoves = game.getLegalGhostMoves(ghostIndex);

            if (legalMoves.contains(lastMove)) {
                return lastMove;
            }
            isDashing = false;
            return Move.NONE;
        }
    }

    private Location getTarget (State s) {
        return s.getPacManLocation();
    }

    private Move chooseBestMove(Game game, int ghostIndex, Location oldLoc) {
        List<Move> legalMoves = game.getLegalGhostMoves(ghostIndex);
        Move bestMove = null;

        double minDistance = Double.POSITIVE_INFINITY;
        for (Move m : legalMoves)
        {
            Location newLoc = Game.getNextLocation(oldLoc, m);
            double distance = Location.euclideanDistance(newLoc, target);
            if (distance < minDistance)
            {
                minDistance = distance;
                bestMove = m;
            }
        }
        lastMove = bestMove;

        return bestMove;
    }

    private void ConfigureColor (Color color) {
        if (getColor() != color) {
            setColor(color);
        }
    }


}
