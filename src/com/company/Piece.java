package com.company;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    public boolean firstMove = true;
    private Color color;
    String imagePath;
    int value;
    Kind kind;

    public boolean getFirstMove(){
        return firstMove;
    }

    public Piece(Color color) {
        this.color = color;
    }

    public Kind getKind() {
        return kind;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public void imagePath() {
        switch (kind) {
            case PAWN:
                if (getColor() == Color.WHITE) {
                    imagePath = "C:\\Users\\Sara Walter\\Desktop\\ChessGroup1\\src\\image\\white_pawn.png";
                } else {
                    imagePath = "C:\\Users\\Sara Walter\\Desktop\\ChessGroup1\\src\\image\\black_pawn.png";
                }
                break;
            case KING:
                if (getColor() == Color.WHITE) {
                    imagePath = "C:\\Users\\Sara Walter\\Desktop\\ChessGroup1\\src\\image\\black_king.png";
                } else {
                    imagePath = "C:\\Users\\Sara Walter\\Desktop\\ChessGroup1\\src\\image\\black_king.png";
                }
                break;

            default:
                break;
        }

    }

    public ArrayList<Move> checkMoves(int y, int x){
        ArrayList<Move> moves = new ArrayList<>();
        /////////////LOGIC FOR SPECIFIC PIECE HERE, WILL THEN RETURN A "MOVE" LIST OF POSSIBLE MOVES BACK TO GAMEBOARD
        return moves;
    }
    public String toString(){
       return this.color + " " + this.kind;
    }
}