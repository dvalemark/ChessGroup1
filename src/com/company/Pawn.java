package com.company;

import java.util.ArrayList;

public class Pawn extends Piece {


    public Pawn(Color color) {
        super(color);
        this.kind = Kind.PAWN;
        this.value = 1;
        imagePath();
    }

    @Override
    public ArrayList<Move> listPossibleMoves(int y, int x) {
        moves.clear();

        int direction = getDirection();
        movePawn(y,x,direction);

        ////PRINT ALL POSSIBLE MOVES FOR THIS PIECE
        return moves;

    }

    private void movePawn(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        int range =1;
        if (this.getFirstMove()) {
            while (moveHelper.vertical(y, x, range, direction) == null && range != 3) {
                checkMove(y, y + range * direction, x, x);
                range++;
            }
            ////NORMAL FORWARD MOVE
        } else {
                if (moveHelper.vertical(y, x, range, direction) == null) {
                    checkMove(y, y + range * direction, x, x);
            }
        }
        //////THESE ARE THE POSSIBLE ATTACK MOVES
        if (moveHelper.checkMoveWithinBounds((y + direction), x - 1)) {
            Piece possiblePiece = moveHelper.diagonalLeft(y, x, 1, direction);
            takePiece(y, y + direction, x, x - 1, possiblePiece);
        }

        if (moveHelper.checkMoveWithinBounds((y + direction), x + 1)) {
            Piece possiblePiece = moveHelper.diagonalRight(y,x,1,direction);
            takePiece(y, y + direction, x, x + 1, possiblePiece);
        }

    }

    private int getDirection() {
        if (this.getColor() == Color.WHITE) {
            return -1;
        }
        return 1;
    }


    private void checkMove(int y, int toY, int x, int toX) {
        int tempValue = 0;
        moves.add(new Move(tempValue, y, toY, x, toX));
        }


    private void takePiece(int y, int toY, int x, int toX, Piece possiblePiece) {
        if (possiblePiece != null && possiblePiece.getColor() != this.getColor()) {
            moves.add(new Move(possiblePiece.getValue(), y, toY, x, toX));
        }
    }

}


