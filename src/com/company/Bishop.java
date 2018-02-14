package com.company;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
        this.kind = Kind.BISHOP;
        this.value = 3;
        imagePath();
    }

    @Override
    public ArrayList<Move> checkMoves(int y, int x) {
        moves.clear();
        MoveHelper moveHelper = new MoveHelper();
        Boolean foundPiece = false;
        int range = 1;

        while (moveHelper.checkMoveWithinBounds(y - range, x - range) && !foundPiece) {
            Piece possiblePiece = moveHelper.upLeft(y, x, range);
            if (possiblePiece == null) {
                moves.add(new Move(0, y, y - range, x, x - range));
            } else {
                if (possiblePiece.getColor() == this.getColor()) {
                    foundPiece = true;
                } else {
                    moves.add(new Move(possiblePiece.value, y, y - range, x, x - range));
                    foundPiece = true;
                }
            }
            range++;
        }
        range = 1;

        while (moveHelper.checkMoveWithinBounds(y - range, x + range) && !foundPiece) {
            Piece possiblePiece = moveHelper.upRight(y, x, range);
            if (possiblePiece == null) {
                moves.add(new Move(0, y, y - range, x, x + range));
            } else {
                if (possiblePiece.getColor() == this.getColor()) {
                    foundPiece = true;
                } else {
                    moves.add(new Move(possiblePiece.value, y, y - range, x, x + range));
                    foundPiece = true;
                }
            }
            range++;
        }
        range = 1;

        while (moveHelper.checkMoveWithinBounds(y + range, x - range) && !foundPiece) {
            Piece possiblePiece = moveHelper.downLeft(y, x, range);
            if (possiblePiece == null) {
                moves.add(new Move(0, y, y + range, x, x - range));
            } else {
                if (possiblePiece.getColor() == this.getColor()) {
                    foundPiece = true;
                } else {
                    moves.add(new Move(possiblePiece.value, y, y + range, x, x - range));
                    foundPiece = true;
                }
            }
            range++;
        }
        range = 1;

        while (moveHelper.checkMoveWithinBounds(y + range, x + range) && !foundPiece) {
            Piece possiblePiece = moveHelper.downRight(y, x, range);
            if (possiblePiece == null) {
                moves.add(new Move(0, y, y + range, x, x + range));
            } else {
                if (possiblePiece.getColor() == this.getColor()) {
                    foundPiece = true;
                } else {
                    moves.add(new Move(possiblePiece.value, y, y + range, x, x + range));
                    foundPiece = true;
                }
            }
            range++;
        }

        return moves;

    }

}
