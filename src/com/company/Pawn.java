package com.company;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
        this.kind = Kind.PAWN;
        this.value = 1;
        this.imagePath = imagePath();
    }


    private String imagePath() {
        if(getColor() == Color.WHITE){
            return " C:\\Users\\disav\\Documents\\Java\\ChessGroup1\\src\\image\\Wpawn.png";
        }else{
            return " C:\\Users\\disav\\Documents\\Java\\ChessGroup1\\src\\image\\Wpawn.png";
        }
    }

    @Override
    public ArrayList<Move> checkMoves(int y, int x) {
        MoveHelper moveHelper = new MoveHelper();
        ArrayList<Move> moves = new ArrayList<>();
        int direction;
        int value = 0;
        int minBoundryX =1;
        int maxBoundryX =6;
        int maxBoundryY =7;
        int minBoundryY =0;

        if (this.getColor() == Color.WHITE) {
            direction = -1;
        } else {
            direction = 1;
        }
        ////IF PAWN HASN'T MOVE BEFORE
        if (firstMove) {
            int range = 1;
            while (moveHelper.directionForward(y, x, range, direction) == null && range < 3) {
                moves.add(new Move(value, y, (y + range*direction), x, x));
                range++;
            }
            ////NORMAL FORWARD MOVE
        } else {
            for (int range = 1; range <= 1; range++) {
                if (moveHelper.directionForward(y, x, range, direction) == null) {
                    moves.add(new Move(value, y, (y + range*direction), x, x));
                }
            }
        }
        //////THESE ARE THE POSSIBLE ATTACK MOVES
        if (x >= minBoundryX) {
            Piece possibleEnemy = moveHelper.directionForwardLeft(y, x, 1, direction);
            if (possibleEnemy != null && possibleEnemy.getColor() != this.getColor()) {
                value = possibleEnemy.getValue();
                moves.add(new Move(value, y, y + direction, x, x - 1));
                value = 0;
            }
        }

        if(x <= maxBoundryX) {
            Piece possibleEnemy = moveHelper.directionForwardRight(y, x, 1, direction);
            if (possibleEnemy != null && possibleEnemy.getColor() != this.getColor()) {
                value = possibleEnemy.getValue();
                moves.add(new Move(value, y, y + direction, x, x + 1));
                value = 0;
            }
        }
        ////PRINT ALL POSSIBLE MOVES FOR THIS PIECE
        moves.stream().forEach(System.out::println);
        System.out.println("PIECE DONE");
        return moves;
    }
}
