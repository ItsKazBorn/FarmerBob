package lucasPereiraPlayer;

import game.AbstractPlayer;
import game.BoardSquare;
import game.Move;
import game.OthelloGame;

import java.util.List;

public class Player extends AbstractPlayer {

    public Player(int depth) {
        super(depth);
    }

    @Override
    public BoardSquare play(int[][] tab) {

        OthelloGame jogo = new OthelloGame();

        List<Move> jogadas = jogo.getValidMoves(tab, getMyBoardMark());

        return jogadas.get(0).getBardPlace();
    }
}
