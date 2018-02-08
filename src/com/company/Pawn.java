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
    public ArrayList<Move> checkMoves(int y, int x) {
        MoveHelper moveHelper = new MoveHelper();
        ArrayList<Move> moves = new ArrayList<>();
        int direction;
        int tempValue = 0;

        if (this.getColor() == Color.WHITE) {
            direction = -1;
        } else {
            direction = 1;
        }
        ////IF PAWN HASN'T MOVE BEFORE
        if (firstMove) {

            int range = 1;
            while (moveHelper.vertical(y, x, range, direction) == null && range != 3) {
                if (moveHelper.checkMoveWithinBounds((y + range * direction), x)) {
                    moves.add(new Move(tempValue, y, (y + range * direction), x, x));
                }
                range++;

            }
            ////NORMAL FORWARD MOVE
        } else {
            for (int range = 1; range <= 1; range++) {
                if (moveHelper.vertical(y, x, range, direction) == null) {
                    if (moveHelper.checkMoveWithinBounds((y + range * direction), x)) {
                        moves.add(new Move(tempValue, y, (y + range * direction), x, x));
                    }
                }
            }
        }
        //////THESE ARE THE POSSIBLE ATTACK MOVES
        if (moveHelper.checkMoveWithinBounds((y + direction), x - 1)) {
            Piece possibleEnemy = moveHelper.diagonalLeft(y, x, 1, direction);
            if (possibleEnemy != null && possibleEnemy.getColor() != this.getColor()) {
                tempValue = possibleEnemy.getValue();
                moves.add(new Move(tempValue, y, y + direction, x, x - 1));
                tempValue = 0;
            }
        }

        if (moveHelper.checkMoveWithinBounds((y + direction), x + 1)) {
            Piece possibleEnemy = moveHelper.diagonalRight(y, x, 1, direction);
            if (possibleEnemy != null && possibleEnemy.getColor() != this.getColor()) {
                tempValue = possibleEnemy.getValue();
                moves.add(new Move(tempValue, y, y + direction, x, x + 1));
                tempValue = 0;
            }
        }
        ////PRINT ALL POSSIBLE MOVES FOR THIS PIECE
        moves.stream().forEach(System.out::println);
        System.out.println("PIECE DONE");
        return moves;
    }
}
