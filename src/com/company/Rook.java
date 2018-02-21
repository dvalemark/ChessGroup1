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
    public ArrayList<Move> listPossibleMoves(int y, int x) {
        moves.clear();

        checkHorizontalMoves(y,x,1);
        checkHorizontalMoves(y, x, -1);
        checkVerticalMoves(y, x, 1);
        checkVerticalMoves(y, x, -1);


        return moves;
    }




    public void checkHorizontalMoves(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        int tempValue = 0;
        int range = direction;
        Boolean foundPiece = false;
        while (moveHelper.checkMoveWithinBounds(y, x + range) && !foundPiece) {

            Piece possiblePiece = moveHelper.horizontal(y, x, range);
            foundPiece = checkMove(y,y,x,x+range,possiblePiece);
            range += direction;
        }

    }


    public void checkVerticalMoves(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        int range = direction;
        Boolean foundPiece = false;
        while (moveHelper.checkMoveWithinBounds(y + range, x) && !foundPiece) {
            Piece possiblePiece = moveHelper.vertical(y, x, range, 1);
            foundPiece = checkMove(y,y+range,x,x,possiblePiece);

            range += direction;
        }
    }
}

