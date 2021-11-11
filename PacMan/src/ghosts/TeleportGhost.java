package ghosts;

import pacman.*;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class TeleportGhost extends GhostPlayer {

    private Random random = new Random();

    private Location target = null;
    private Move lastMove = null;

    private Location[] teleportPoints;
    private Location[] spawnPoints;

    @Override
    public Move chooseMove(Game game, int ghostIndex) {
        ConfigureColor(Color.MAGENTA);

        getSpawnPoints();
        getTeleportPoints();
        State state = game.getCurrentState();
        Location ghostLocation = state.getGhostLocations().get(ghostIndex);
        target = getTarget(ghostLocation);

        return chooseBestMove(game, ghostIndex, ghostLocation);
    }

    private void getSpawnPoints(){
        if (spawnPoints == null){
            spawnPoints = new Location[]{
                    new Location(0,0),
                    new Location(25,25),
                    new Location(0, 25),
                    new Location(25, 0)
            };
        }
    }

    private void getTeleportPoints(){
        if (teleportPoints == null){
            teleportPoints = new Location[]{
                    new Location(0,15),
                    new Location(25,15)
            };
        }
    }

    private Location getTarget(Location ghostLocation)
    {
        Location nextLocation = null;
        if (target == null)
        {
            return teleportPoints[random.nextInt(teleportPoints.length)];
        }
        for (int i = 0; i < teleportPoints.length; i++)
        {
            if (ghostLocation.equals(teleportPoints[i]))
            {
                nextLocation = new Location(0, 0);
                if (i == teleportPoints.length-1)
                {
                    return teleportPoints[random.nextInt(teleportPoints.length)];
                }
                int next = i+1;
                return teleportPoints[next];
            }
        }
        return target;
    }

    public static Location getNextSpawn(Location l, Move m) {
        Location next = null;
        if (m == Move.LEFT && l.getY() == 15 && l.getX() == 0) {
            next = new Location(0, 0);
        } else if (m == Move.RIGHT && l.getY() == 15 && l.getX() == 25) {
            next = new Location(25, 0);
        } else {
            switch (m) {
                case NONE:
                    next = l;
                    break;
                case UP:
                    next = new Location(l.getX(), l.getY() + 1);
                    break;
                case DOWN:
                    next = new Location(l.getX(), l.getY() - 1);
                    break;
                case LEFT:
                    next = new Location(l.getX() - 1, l.getY());
                    break;
                case RIGHT:
                    next = new Location(l.getX() + 1, l.getY());
                    break;
            }
        }
        return next;
    }

    private Move chooseBestMove(Game game, int ghostIndex, Location ghostLocation) {
        List<Move> legalMoves = game.getLegalGhostMoves(ghostIndex);
        Move bestMove = null;

        double minDistance = Double.POSITIVE_INFINITY;
        for (Move m : legalMoves)
        {
            Location newLoc = getNextSpawn(ghostLocation, m);
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
