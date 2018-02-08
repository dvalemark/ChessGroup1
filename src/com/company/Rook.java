package com.company;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
        this.kind = Kind.ROCK;
        this.value = 5;
        imagePath();
    }

    @Override
    public ArrayList<Move> checkMoves(int y, int x) {
        ArrayList<Move> moves = new ArrayList<>();
        checkHorizontalMoves(y, x, 1);
        checkHorizontalMoves(y, x, -1);
        return moves;
    }

    public void checkHorizontalMoves(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        int tempValue = 0;
        int range = 1;
        Boolean outOfBounds = true;
        do {
            System.out.println(range);
                Piece possibleEnemy = moveHelper.horizontal(y, x, 1, direction);
                if (possibleEnemy == null) {
                    moves.add(new Move(tempValue, y, y, x, (x + range * direction)));
                    range += direction;
                } else {
                    moves.add(new Move(possibleEnemy.value, y, y, x, (x + range * direction)));
                }
        } while (moveHelper.horizontal(y,x,range, direction) == null || moveHelper.checkMoveWithinBounds(y, x + range * direction));
    }
}

