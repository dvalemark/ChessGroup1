package com.company;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.HashMap;
import java.util.Map;

public class Gameboard {
    private Map<Position, Piece> gameboard;
    final int WIDTH = 8;

    public Gameboard() {
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

    public void drawSquares(com.googlecode.lanterna.screen.Screen screen) {
        for (Map.Entry<Position, Piece> entry : gameboard.entrySet()) {
            if (entry.getKey().color == Color.WHITE) {
                screen.putString(entry.getKey().x, entry.getKey().y, " ", Terminal.Color.BLACK, Terminal.Color.WHITE);
            } else {
                screen.putString(entry.getKey().x, entry.getKey().y, " ", Terminal.Color.BLACK, Terminal.Color.BLACK);
            }
        }
        screen.refresh();
    }

}
