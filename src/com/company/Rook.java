package com.company;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
        this.kind = Kind.ROCK;
        this.value = 1;
        imagePath();
    }


}
