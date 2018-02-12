package com.company;

import java.net.URL;
import java.util.ArrayList;

public class Piece {
    ArrayList<Move> moves;
    public boolean firstMove;
    private Color color;
    URL imagePath;
    int value;
    Kind kind;

    public Piece(Color color){
        this.moves = new ArrayList<>();
        firstMove =true;
        this.color = color;
    }

    public boolean getFirstMove(){
        return firstMove;
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
                    imagePath = getClass().getResource("/resources/images/white_pawn.png");
                } else {
                    imagePath = getClass().getResource("/resources/images/black_pawn.png");
                }
                break;
            case KING:
                if (getColor() == Color.WHITE) {
                    imagePath = getClass().getResource("/resources/images/black_king.png");
                } else {
                    imagePath = getClass().getResource("/resources/images/black_king.png");
                }
                break;

            case ROOK:
                if(getColor() == Color.WHITE){
                    imagePath = getClass().getResource("/resources/images/black_king.png");
            }
                break;

            default:
                break;
        }

    }

    public ArrayList<Move> checkMoves(int y, int x){
        ArrayList<Move> moves = new ArrayList<>();
        return moves;
    }
    public String toString(){
       return this.color + " " + this.kind;
    }
}