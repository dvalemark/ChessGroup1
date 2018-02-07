package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MoveHelper {
    private Tile[][] tiles = GameBoard.tile;


    public Piece directionForwardLeft(int y, int x, int range, int direction) {
        return tiles[y + range * direction][x - range].getPiece();
    }

    public Piece directionForwardRight(int y, int x, int range, int direction) {
        return tiles[y + range * direction][x + range].getPiece();
    }

    public Piece directionForward(int y, int x, int range, int direction) {
        return tiles[y + (range * direction)][x].getPiece();
    }

    public void analyzeMoves(Color color) {
        GameBoard gameBoard = new GameBoard();
        ArrayList<Move> moves = new ArrayList<>();
        System.out.println("STARTING TO ANALYZE MOVES FOR PLAYER " + color);
        for (int y = 0; y < gameBoard.getWIDTH(); y++) {
            for (int x = 0; x < gameBoard.getWIDTH(); x++) {
                if (tiles[y][x].getPiece() != null && tiles[y][x].getPiece().getColor() == color) {
                    Piece piece = tiles[y][x].getPiece();
                    moves.addAll(piece.checkMoves(y, x));
                }
            }
        }
        Collections.shuffle(moves);
        Move bestMove = moves
                .stream()
                .max(Comparator.comparing(Move::getValue)).orElseThrow(NoSuchElementException::new);

        gameBoard.movePiece(bestMove);
    }
}
