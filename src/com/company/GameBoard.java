package com.company;

import java.util.*;
import java.util.Collections.*;

public class GameBoard {
    private final int PAWN = 8;
    private final int WIDTH = 8;
    public static Spot[][] spots;


    GameBoard() {
        spots = new Spot[WIDTH][WIDTH];
        fillList();
        addPieces();
    }

    ///ADD 64 SPOTS
    private void fillList() {
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < WIDTH; x++) {
                spots[y][x] = new Spot();
            }
        }

    }

    ///ADD PIECES TO CORRECT SLOTS
    private void addPieces() {
        ////ADD WHITE PIECES///////////
        spots[0][4].setPiece(new King(Color.BLACK));
        for (int i = 0; i < PAWN; i++) {
            spots[1][i].setPiece(new Pawn(Color.BLACK));
        }
        ////ADD BLACK PIECES///////////
        spots[7][4].setPiece(new King(Color.WHITE));
        for (int i = 0; i < PAWN; i++) {
            spots[6][i].setPiece(new Pawn(Color.WHITE));
        }
    }

    public void analyzeMoves(Color color) {
        ArrayList<Move> moves = new ArrayList<>();
        System.out.println("STARTING TO ANALYZE MOVES FOR PLAYER " + color);
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (spots[y][x].getPiece() != null && spots[y][x].getPiece().getColor() == color) {
                    Piece piece = spots[y][x].getPiece();
                    moves.addAll(piece.checkMoves(y, x));
                }
            }
        }
        Collections.shuffle(moves);
        Move bestMove = moves
                .stream()
                .max(Comparator.comparing(Move::getValue)).orElseThrow(NoSuchElementException::new);

        makeMove(bestMove);
    }
    ///MOVE ONE PIECE
    public void makeMove(Move move) {
        Piece pieceToMove = spots[move.fromY][move.fromX].getPiece();
        spots[move.fromY][move.fromX].setPiece(null);
        spots[move.toY][move.toX].setPiece(pieceToMove);
        System.out.println("MOVED " + pieceToMove.toString() + " TO " + move.toY + ":" + move.toX);

            pieceToMove.firstMove = false;

    }

}
