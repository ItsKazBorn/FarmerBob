package lucasPereiraPlayer;

import game.*;

import java.util.List;

public class GulosoPlayer extends AbstractPlayer {

    public GulosoPlayer(int depth) {
        super(depth);
    }

    @Override
    public BoardSquare play(int[][] tab) {

        OthelloGame game = new OthelloGame();

        List<Move> moves = game.getValidMoves(tab, getMyBoardMark());

        Move bestMove = moves.get(0);
        int bestScore = 0;

        for (Move move: moves) {
            int score = CheckScore(tab, move);

            if (score > bestScore) {
                bestMove = move;
                bestScore = score;
            }
        }

        System.out.println(bestMove.getBardPlace().getCol());
        System.out.println(bestMove.getBardPlace().getRow());
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
        int[][] newTab = new int[tab.length][tab[0].length];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                newTab[i][j] = tab[i][j];
            }
        }
        return newTab;
    }
}
