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
        moves.clear();
        checkHorizontalMoves(y, x, 1);
        checkHorizontalMoves(y, x, -1);
        System.out.println(moves);
        return moves;
    }

    public void checkHorizontalMoves(int y, int x, int direction) {
        MoveHelper moveHelper = new MoveHelper();
        int tempValue = 0;
        int range = 1;
        while (moveHelper.checkMoveWithinBounds(y, x + range * direction) &&  moveHelper.horizontal(y,x,range, direction) == null){
                Piece possibleEnemy = moveHelper.horizontal(y, x, 1, direction);
                if (possibleEnemy == null) {
                    moves.add(new Move(tempValue, y, y, x, (x + range * direction)));
                    range += direction;
                } else {
                    moves.add(new Move(possibleEnemy.value, y, y, x, (x + range * direction)));
                }
        } ;
    }
}

