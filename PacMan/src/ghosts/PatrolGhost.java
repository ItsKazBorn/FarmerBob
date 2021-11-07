package ghosts;

import pacman.Game;
import pacman.GhostPlayer;
import pacman.Location;
import pacman.Move;
import pacman.State;

import java.awt.*;
import java.util.List;

public class PatrolGhost extends GhostPlayer {

    private Location target = null;
    private Move lastMove = null;

    private Location[] patrolPoints;



    @Override
    public Move chooseMove(Game game, int ghostIndex)
    {
        ConfigureColor(Color.gray);

        getPatrolPoints();
        State s = game.getCurrentState();
        Location oldLoc = s.getGhostLocations().get(ghostIndex);
        target = getTarget(oldLoc);

        return chooseBestMove(game, ghostIndex, oldLoc);
    }

    private void getPatrolPoints()
    {
        if (patrolPoints == null)
        {
            patrolPoints = new Location[] {
                    new Location(20, 24),
                    new Location(20, 6),
                    new Location(5, 6),
                    new Location(5,24)
            };
        }
    }

    private Location getTarget(Location oldLoc)
    {
        if (target == null)
        {
            return patrolPoints[0];
        }
        for (int i = 0; i < patrolPoints.length; i++)
        {
            if (oldLoc.equals(patrolPoints[i]))
            {
                if (i == patrolPoints.length-1)
                {
                    return patrolPoints[0];
                }
                int next = i+1;
                return patrolPoints[next];
            }
        }
        return target;
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

