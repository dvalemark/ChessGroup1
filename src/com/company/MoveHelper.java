package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MoveHelper {
    private Tile[][] tile = GameBoard.tile;
    int direction;
    int minBoundry =0;
    int maxBoundry =7;
    private int WIDTH =8;


    public Boolean checkMoveWithinBounds(int y, int x){
            if(y > maxBoundry || y < minBoundry || x > maxBoundry || x < minBoundry ){
                return false;
            }
            return true;
    }

    public Piece diagonalLeft(int y, int x, int range, int direction) {

        return tile[y + range * direction][x - range].getPiece();
    }
    public Piece diagonalRight(int y, int x, int range, int direction) {
        return tile[y + range * direction][x + range].getPiece();
    }

    public Piece vertical(int y, int x, int range, int direction) {
        return tile[y + (range * direction)][x].getPiece();
    }
    public Piece horizontal(int y, int x, int range) {
        return tile[y][x+ range].getPiece();
    }

    //////BISHOP METHODS///////////////
    public Piece upLeft(int y, int x, int range) {
        return tile[y - range][x - range].getPiece();
    }
    public Piece upRight(int y, int x, int range) {
        return tile[y - range][x + range].getPiece();
    }
    public Piece downRight(int y, int x, int range) {
        return tile[y + range][x + range].getPiece();
    }
    public Piece downLeft(int y, int x, int range) {
        return tile[y + range][x - range].getPiece();
    }
    ///////////////////////////////////////

    public void analyzeMoves(Color color) {
        ArrayList<Move> moves = new ArrayList<>();
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x <WIDTH; x++) {
                if (tile[y][x].getPiece() != null && tile[y][x].getPiece().getColor() == color) {
                    Piece piece = tile[y][x].getPiece();
                    moves.addAll(piece.checkMoves(y, x));
                }
            }
        }
        Collections.shuffle(moves);
        if(moves.size() > 1) {
            Move bestMove = moves
                    .stream()
                    .max(Comparator.comparing(Move::getValue)).orElseThrow(NoSuchElementException::new);
            movePiece(bestMove);
        }else {
            movePiece(moves.get(0));
        }
    }



    public void movePiece(Move move) {
        Piece pieceToMove = tile[move.fromY][move.fromX].getPiece();
        tile[move.fromY][move.fromX].setPiece(null);
        tile[move.toY][move.toX].setPiece(pieceToMove);
        System.out.println("MOVED " + pieceToMove.toString() + " TO " + move.toY + ":" + move.toX);


        pieceToMove.firstMove = false;

    }
}
