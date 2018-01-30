package com.company;


import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<Position, Piece> gameboard;
    final int WIDTH = 8;

    public Game() {
        this.gameboard = new HashMap<>();
        addSquares();
    }

    private void addSquares() {
        Color color;
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (y % 2 == 0) {
                    if (x % 2 != 0) {
                        color = Color.WHITE;
                    } else {
                        color = Color.BLACK;
                    }
                } else {
                    if (x % 2 == 0) {
                        color = Color.WHITE;
                    } else {
                        color = Color.BLACK;
                    }
                }
                gameboard.put(new Position(x, y, color), null);
            }
        }
    }

}
