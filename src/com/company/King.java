package com.company;

import java.util.ArrayList;

public class King extends Piece {

    public King(Color color) {
        super(color);
        this.value = -1;
        this.kind = Kind.KING;
        imagePath();
    }

    public ArrayList<Move> listPossibleMoves(int y, int x) {
        moves.clear();

        moveVertical(y, x, 1);
        moveVertical(y, x, -1);
        moveHorizontal(y,x,1);
        moveHorizontal(y,x,-1);
        leftDiagonalUpDown(y,x,1);
        leftDiagonalUpDown(y,x,-1);
        rightDiagonalDown(y,x,1);
        rightDiagonalUp(y,x,1);

        System.out.println(moves);
        return moves;
    }

    public void moveVertical(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        Piece possiblePiece;

        if (moveHelper.checkMoveWithinBounds((y + direction), x)) {
            possiblePiece = moveHelper.vertical(y, x, 1, direction);
            boolean foundPiece = checkMove(y,y+direction,x,x,possiblePiece);
        }


    }

    public void moveHorizontal(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        Piece possiblePiece;

        if (moveHelper.checkMoveWithinBounds(y , x+direction)) {
            possiblePiece = moveHelper.horizontal(y, x, direction);
            boolean foundPiece = checkMove(y,y,x,x+direction,possiblePiece);
        }


    }

    public void leftDiagonalUpDown(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        int tempValue = 0;
        Piece possiblePiece;

        if (moveHelper.checkMoveWithinBounds(y +direction, x+direction)) {
            possiblePiece = moveHelper.upLeft(y, x, +direction);
            boolean foundPiece = checkMove(y,y+direction, x,x+direction, possiblePiece);
        }


    }

    public void rightDiagonalDown(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        Piece possiblePiece;

        if (moveHelper.checkMoveWithinBounds(y +direction, x-direction)) {
            possiblePiece = moveHelper.downLeft(y, x, direction);
            boolean foundPiece = checkMove(y, y+direction, x, x-direction, possiblePiece);
        }

    }

    public void rightDiagonalUp(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        Piece possiblePiece;

        if (moveHelper.checkMoveWithinBounds(y -direction, x+direction)) {
            possiblePiece = moveHelper.upRight(y, x, direction);
            boolean foundPiece = checkMove(y,y-direction, x, x+direction, possiblePiece);
        }


    }


}


