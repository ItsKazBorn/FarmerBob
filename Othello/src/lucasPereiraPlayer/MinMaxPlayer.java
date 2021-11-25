package lucasPereiraPlayer;

import game.AbstractPlayer;
import game.BoardSquare;
import game.Move;
import game.OthelloGame;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;

public class MinMaxPlayer extends AbstractPlayer {

    public MinMaxPlayer(int depth) {
        super(depth);
    }

    @Override
    public BoardSquare play(int[][] tab) {
        OthelloGame game = new OthelloGame();

        List<Move> moves = game.getValidMoves(tab, getMyBoardMark());

        Move bestMove = moves.get(0);
        int bestMinMax = -9999999;
        boolean isCorner = false;

        for (Move move: moves) {
            System.out.println("  >>---> Start Depth");
            int minmax = Depth(0,0, move, CloneTab(tab));
            System.out.println(" >>---> End Depth");
            System.out.println("MinMax: " + minmax);

            if (move.getBardPlace().getCol() == 0){
                if(move.getBardPlace().getRow() == 0){
                    isCorner = true;
                    bestMove = move;
                }
                else if (move.getBardPlace().getRow() == tab.length - 1){
                    isCorner = true;
                    bestMove = move;
                }
            }
            else if (move.getBardPlace().getCol() == tab[0].length - 1){
                if(move.getBardPlace().getRow() == 0){
                    isCorner = true;
                    bestMove = move;
                }
                else if (move.getBardPlace().getRow() == tab.length-1){
                    isCorner = true;
                    bestMove = move;
                }
            }

            if (minmax > bestMinMax && !isCorner) {
                bestMove = move;
                bestMinMax = minmax;
            }
        }

        System.out.println("------------------------");
        System.out.println("Best Min Max: " + bestMinMax);
        return bestMove.getBardPlace();
    }

    private int Depth (int currentMinMax, int depth, Move move, int[][] tab) {
        OthelloGame game = new OthelloGame();
        if (depth > getDepth() || game.noSpace(tab)) {
            int score = CheckMinMax(tab);
            currentMinMax += score;
            System.out.println("Score: " + score);
            System.out.println("CurrentMinMax: " + currentMinMax);
            return currentMinMax;
        }
        else {
            if (depth % 2 == 0) {
                tab = do_move(tab, move.getBardPlace(), getMyBoardMark());

                if (depth+1 <= getDepth()) {
                    List<Move> moves = game.getValidMoves(tab, getOpponentBoardMark());
                    for (Move newMove: moves) {
                        currentMinMax = Depth(currentMinMax, depth+1, newMove, tab);
                    }
                }
                else {
                    int score = CheckMinMax(tab);
                    currentMinMax += score;
                    System.out.println("Score: " + score);
                    System.out.println("CurrentMinMax: " + currentMinMax);
                    return score;
                }
            }
            else {
                tab = do_move(tab, move.getBardPlace(), getOpponentBoardMark());

                if (depth+1 <= getDepth()) {
                    List<Move> moves = game.getValidMoves(tab, getMyBoardMark());
                    for (Move newMove: moves) {
                        currentMinMax += Depth(currentMinMax, depth+1, newMove, tab);
                    }
                }
                else {
                    int score = CheckMinMax(tab);
                    currentMinMax += score;
                    System.out.println("Score: " + score);
                    System.out.println("CurrentMinMax: " + currentMinMax);
                    return score;
                }
            }
        }
        return currentMinMax;
    }

    public int CheckMinMax(int[][] tab) {
        OthelloGame game = new OthelloGame();
        int mine = 0;
        int oppo = 0;

        for (int row = 0; row < game.size; row++) {
            for (int col = 0; col < game.size; col++) {
                if (tab[row][col] == getMyBoardMark()) {
                    mine++;
                }
                if (tab[row][col] == getOpponentBoardMark()) {
                    oppo++;
                }
            }
        }

        if (mine > oppo) { return 1; }
        else if (mine < oppo) { return -1; }
        else { return 0; }
    }

    private int[][] Domove (int[][] tabOriginal, Move move, int boardMark) {
        var tab = CloneTab(tabOriginal);
        var newTab = do_move(tab, move.getBardPlace(), boardMark);
        return newTab;
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

    // Copiado do Game pra poder usar boardMark ao invés de AbstractPlayer
    public int[][] do_move(int[][] board, BoardSquare boardPlace, int boardMark) {
//        skip play
        if (boardPlace.getRow() == -1 && boardPlace.getCol() == -1) {
            return board;
        }

        board[boardPlace.getRow()][boardPlace.getCol()] = boardMark;
        // search own mark in backwards line
        int position = -1;
        for (int i = boardPlace.getRow() - 1; i >= 0; i--) {
            // rdr - whether find an empty spot before the player mark
            if (board[i][boardPlace.getCol()] == 0) {
                break;
            }
            if (board[i][boardPlace.getCol()] == boardMark) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            position++;
            for (int i = position; i < boardPlace.getRow(); i++) {
                if (board[i][boardPlace.getCol()] != 0) {
                    board[i][boardPlace.getCol()] = boardMark;
                }
            }
        }
        // search own mark in forward lines
        position = -1;
        for (int i = boardPlace.getRow() + 1; i < 8; i++) {
            // rdr - whether find an empty spot before the player marks
            if (board[i][boardPlace.getCol()] == 0) {
                break;
            }
            if (board[i][boardPlace.getCol()] == boardMark) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            position--;
            for (int i = position; i > boardPlace.getRow(); i--) {
                if (board[i][boardPlace.getCol()] != 0) {
                    board[i][boardPlace.getCol()] = boardMark;
                }
            }
        }
        /**
         * **************************************************************************************
         */
        //search own mark in col in backwards line
        position = -1;
        for (int i = boardPlace.getCol() - 1; i >= 0; i--) {
            //rdr - whether find an empty spot before the player marks
            if (board[boardPlace.getRow()][i] == 0) {
                break;
            }
            if (board[boardPlace.getRow()][i] == boardMark) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            position++;
            for (int i = position; i < boardPlace.getCol(); i++) {
                if (board[boardPlace.getRow()][i] != 0) {
                    board[boardPlace.getRow()][i] = boardMark;
                }
            }
        }
        // search own mark in rows in forward lines
        position = -1;
        for (int i = boardPlace.getCol() + 1; i < 8; i++) {
            // rdr - whether find an empty spot before the player marks
            if (board[boardPlace.getRow()][i] == 0) {
                break;
            }
            if (board[boardPlace.getRow()][i] == boardMark) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            position--;
            for (int i = position; i > boardPlace.getCol(); i--) {
                if (board[boardPlace.getRow()][i] != 0) {
                    board[boardPlace.getRow()][i] = boardMark;
                }
            }
        }
        /**
         * ******************************************************
         */
        // search own mark in backwards diagonals
        int row = boardPlace.getRow() - 1;
        int col = boardPlace.getCol() - 1;
        // rdr - indicates whether an empty spot was found before player mark
        boolean empty = false;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == boardMark) {
                break;
            }
            // rdr - exits loop if an empty spot was found
            if (board[row][col] == 0) {
                empty = true;
                break;
            }
            row--;
            col--;
        }
        if (row >= 0 && col >= 0 && !empty) { // rdr - check if it is empty
            while (row != boardPlace.getRow()
                    && col != boardPlace.getCol()) {
                if (board[row][col] != 0) {
                    board[row][col] = boardMark;
                }
                row++;
                col++;
            }
        }
        //search own mark in forward diagonal
        row = boardPlace.getRow() + 1;
        col = boardPlace.getCol() + 1;

        empty = false;
        while (row < 8 && col < 8) {
            if (board[row][col] == boardMark) {
                break;
            }
            if (board[row][col] == 0) {
                empty = true;
                break;
            }
            row++;
            col++;
        }
        if (row < 8 && col < 8 && !empty) {
            while (row != boardPlace.getRow()
                    && col != boardPlace.getCol()) {
                if (board[row][col] != 0) {
                    board[row][col] = boardMark;
                }
                row--;
                col--;
            }
        }
        /**
         * ******************************************************
         */
        //search own mark in backwards inverse diagonal
        row = boardPlace.getRow() - 1;
        col = boardPlace.getCol() + 1;
        empty = false;
        while (row >= 0 && col < 8) {
            if (board[row][col] == boardMark) {
                break;
            }
            if (board[row][col] == 0) {
                empty = true;
                break;
            }
            row--;
            col++;
        }
        if (row >= 0 && col < 8 && !empty) {
            while (row != boardPlace.getRow()
                    && col != boardPlace.getCol()) {
                if (board[row][col] != 0) {
                    board[row][col] = boardMark;
                }
                row++;
                col--;
            }
        }
        //search own mark in forwards inverse diagonal
        row = boardPlace.getRow() + 1;
        col = boardPlace.getCol() - 1;
        empty = false;
        while (row < 8 && col >= 0) {
            if (board[row][col] == boardMark) {
                break;
            }
            if (board[row][col] == 0) {
                empty = true;
                break;
            }
            row++;
            col--;
        }
        if (row < 8 && col >= 0 && !empty) {
            while (row != boardPlace.getRow()
                    && col != boardPlace.getCol()) {
                if (board[row][col] != 0) {
                    board[row][col] = boardMark;
                }
                row--;
                col++;
            }
        }
        /**
         * ******************************************************
         */
        return board;
    }
}
