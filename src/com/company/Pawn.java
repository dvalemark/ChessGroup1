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
            return "C:\\Users\\Sara Walter\\Desktop\\ChessGroup1\\src\\images\\white_pawn.png";
        }else{
            return "C:\\Users\\Sara Walter\\Desktop\\ChessGroup1\\src\\images\\black_pawn.png";
        }
    }

    @Override
    public ArrayList<Move> checkMoves(int y, int x) {
        MoveHelper moveHelper = new MoveHelper();
        ArrayList<Move> moves = new ArrayList<>();
        int direction;
        int value = 0;
        if (this.getColor() == Color.WHITE) {
            direction = -1;
        } else {
            direction = 1;
        }
        ////IF PAWN HASN'T MOVE BEFORE
        if (firstMove) {
            int i = 1;
            while (moveHelper.isForward(y, x, i, direction) == null && i != 3) {
                moves.add(new Move(value, y, (y + i*direction), x, x));
                i++;
            }
            ////NORMAL FORWARD MOVE
        } else {
            for (int i = 1; i <= 1; i++) {
                if (moveHelper.isForward(y, x, i, direction) == null) {
                    moves.add(new Move(value, y, (y + i*direction), x, x));
                }
            }
        }
        //////THESE ARE THE POSSIBLE ATTACK MOVES
        if (x >= 1) {
            Piece possibleEnemy = moveHelper.isForwardLeft(y, x, 1, direction);
            if (possibleEnemy != null && possibleEnemy.getColor() != this.getColor()) {
                value = possibleEnemy.getValue();
                moves.add(new Move(value, y, y + direction, x, x - 1));
                value = 0;
            }
        }
        if(x <= 6) {
            Piece possibleEnemy = moveHelper.isForwardRight(y, x, 1, direction);
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
