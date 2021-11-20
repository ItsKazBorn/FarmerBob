package lucasPereiraPlayer;

import game.AbstractPlayer;
import game.BoardSquare;
import game.Move;
import game.OthelloGame;

import java.util.List;

public class GulosoPlayer extends AbstractPlayer {

    public GulosoPlayer(int depth) {
        super(depth);
    }

    @Override
    public BoardSquare play(int[][] tab) {

        OthelloGame jogo = new OthelloGame();

        List<Move> jogadas = jogo.getValidMoves(tab, getMyBoardMark());

        Move bestMove = jogadas.get(0);
        int bestScore = 0;

        for (Move jogada: jogadas) {
            int score = CheckScore(tab, jogada);

            if (score > bestScore) {
                bestMove = jogada;
                bestScore = score;
            }
        }

        return bestMove.getBardPlace();
    }

    private int CheckScore (int[][] tabOriginal, Move move) {
        OthelloGame jogo = new OthelloGame();
        var tab = CloneTab(tabOriginal);
        jogo.do_move(tab, move.getBardPlace(), this);

        int mine = 0;

        for (int row = 0; row < jogo.size; row++) {
            for (int col = 0; col < jogo.size; col++) {
                if (tab[row][col] == getMyBoardMark()) {
                    mine++;
                }
            }
        }

        return mine;
    }

    private int[][] CloneTab(int[][] tab) {
        int[][] newTab = new int[3][3];

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                newTab[i][j] = tab[i][j];
            }
        }
        return newTab;
    }
}
