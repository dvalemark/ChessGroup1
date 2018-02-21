package com.company;

public class Move {
    int value;
    int fromY;
    int toY;
    int fromX;
    int toX;

    public Move(int value,int fromY, int toY, int fromX, int toX) {
        this.value = value;
        this.fromY = fromY;
        this.toY = toY;
        this.fromX = fromX;
        this.toX = toX;
    }

    @Override
    public String toString() {
        String string = this.toY + ":" + this.toX + " Value: " + this.value;
        return string;
    }

    public int getValue() {
        return value;
    }
}
