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
    public ArrayList<Move> listPossibleMoves(int y, int x) {
        moves.clear();
        MoveHelper moveHelper = new MoveHelper();
        Boolean foundPiece = false;
        int range = 1;
        moveLeftDiagonalUpDown(y,x,range);
        moveLeftDiagonalUpDown(y,x,-range);
        moveRightDiagonalUp(y,x,range);
        moveRightDiagonalDown(y,x,range);

        return moves;

    }

    public void moveLeftDiagonalUpDown(int y, int x, int range){
        MoveHelper moveHelper = new MoveHelper();
        boolean foundPiece = false;
        while (moveHelper.checkMoveWithinBounds(y + range, x + range) && !foundPiece) {
            Piece possiblePiece = moveHelper.upLeft(y, x, range);
            foundPiece = checkMove(y,y+range,x,x+range,possiblePiece);
            range++;
        }
    }

    private void moveRightDiagonalDown(int y, int x, int range) {
        MoveHelper moveHelper = new MoveHelper();
        boolean foundPiece = false;
        while (moveHelper.checkMoveWithinBounds(y + range, x - range) && !foundPiece) {
            Piece possiblePiece = moveHelper.downLeft(y, x, range);

            foundPiece = checkMove(y,y+range,x,x-range,possiblePiece);

            range++;
        }
    }


    public void moveRightDiagonalUp(int y, int x, int range){
        MoveHelper moveHelper = new MoveHelper();
        boolean foundPiece = false;
        while (moveHelper.checkMoveWithinBounds(y - range, x + range) && !foundPiece) {
            Piece possiblePiece = moveHelper.upRight(y, x, range);
            foundPiece = checkMove(y,y-range,x,x+range,possiblePiece);
            range++;
        }
    }

}
