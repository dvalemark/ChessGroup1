package com.company;

public class King extends Piece {

    public King(Color color) {
        super(color);
        this.value = -1;
        this.kind = Kind.KING;
        imagePath();
    }
}
