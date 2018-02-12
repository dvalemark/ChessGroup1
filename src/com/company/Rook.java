package com.company;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
        this.kind = Kind.ROOK;
        this.value = 5;
        imagePath();
    }

    @Override
    public ArrayList<Move> checkMoves(int y, int x) {
        moves.clear();

        checkHorizontalMoves(y,x,1);
        checkHorizontalMoves(y, x, -1);
        checkVerticalMoves(y, x, 1);
        checkVerticalMoves(y, x, -1);


        System.out.println(moves);
        return moves;
    }




    public void checkHorizontalMoves(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        int tempValue = 0;
        int range = direction;
        Boolean foundPiece = false;
        while (moveHelper.checkMoveWithinBounds(y, x + range) && !foundPiece) {

            Piece possiblePiece = moveHelper.horizontal(y, x, range);
            if (possiblePiece == null) {
                moves.add(new Move(tempValue, y, y, x, (x + range)));
            } else {
                if (possiblePiece.getColor() == this.getColor()) {
                    foundPiece = true;
                } else {
                    moves.add(new Move(possiblePiece.value, y, y, x, x + range));
                    foundPiece = true;

                }
            }
            range += direction;
        }

    }


    public void checkVerticalMoves(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        int tempValue = 0;
        int range = direction;
        Boolean foundPiece = false;
        while (moveHelper.checkMoveWithinBounds(y + range, x) && !foundPiece) {
            Piece possiblePiece = moveHelper.vertical(y, x, range, 1);
            if (possiblePiece == null) {
                moves.add(new Move(tempValue, y, y + range, x, x));
            } else {
                if (possiblePiece.getColor() == this.getColor()) {
                    foundPiece = true;
                } else {
                    moves.add(new Move(possiblePiece.value, y, y + range, x, x));
                    foundPiece = true;
                }

            }
            range += direction;
        }
    }
}

