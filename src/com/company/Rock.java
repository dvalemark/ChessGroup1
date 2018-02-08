package com.company;

public class Rock extends Piece {

    public Rock(Color color) {
        super(color);
        this.kind = Kind.ROCK;
        this.value = 1;
        imagePath();
    }


}
