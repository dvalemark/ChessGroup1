package sample;

import java.util.ArrayList;

public class Piece {
    private Color color;
    int value;
    Kind kind;

    public Piece(Color color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
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