package com.company;


import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<Position, Piece> gameboard;
    final int WIDTH = 8;

    public Game() {
        this.gameboard = new HashMap<>();
        fillMap();
    }

    private void fillMap() {
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < WIDTH; x++) {
                gameboard.put(new Position(x, y), null);
            }
        }
    }

}
