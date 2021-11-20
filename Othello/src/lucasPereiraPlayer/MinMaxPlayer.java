package lucasPereiraPlayer;

import game.AbstractPlayer;
import game.BoardSquare;
import game.Move;
import game.OthelloGame;

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

        for (Move move: moves) {
            Depth(0, move, tab);
        }


        return null;
    }

    private void Depth (int depth, Move move, int[][] tab) {
        System.out.println("Depth: " + depth + "/" + getDepth());
        OthelloGame game = new OthelloGame();
        if (depth >= getDepth() || game.noSpace(tab)) {
            System.out.println("Depth Reached");
            return;  // Check MINMAX
        }
        else {
            if (depth % 2 == 0) {
                System.out.println("Making my move");
                tab = do_move(tab, move.getBardPlace(), getMyBoardMark());

                if (depth+1 <= getDepth()) {
                    List<Move> moves = game.getValidMoves(tab, getOpponentBoardMark());
                    for (Move newMove: moves) {
                        Depth(depth+1, newMove, tab);
                    }
                }
                else {
                    System.out.println("Depth Reached");
                    return; //
                }
            }
            else {
                System.out.println("Making opponent move");
                tab = do_move(tab, move.getBardPlace(), getOpponentBoardMark());

                if (depth+1 <= getDepth()) {
                    List<Move> moves = game.getValidMoves(tab, getMyBoardMark());
                    for (Move newMove: moves) {
                        Depth(depth+1, newMove, tab);
                    }
                }
                else {
                    System.out.println("Depth Reached");
                    return; //
                }
            }
        }
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
