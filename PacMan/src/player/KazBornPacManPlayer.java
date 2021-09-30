package player;
import pacman.*;
import java.util.List;
import java.util.Random;

// Minha primeira implementação  do  pacman player
public class KazBornPacManPlayer implements PacManPlayer {

    // Unico método que deve ser obrigatoriamente implementado
    public Move chooseMove (Game game) {
        List<Move> legalMoves = game.getLegalPacManMoves();
        Random rand  = new Random();
        int index = rand.nextInt(legalMoves.size());
        return legalMoves.get(index);
    }

}
