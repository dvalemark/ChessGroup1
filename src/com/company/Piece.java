package com.company;

import java.util.ArrayList;

public class Piece {
    ArrayList<Move> moves;
    public boolean firstMove;
    private Color color;
    String imagePath;
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
        return moves;
    }
    public String toString(){
       return this.color + " " + this.kind;
    }
}