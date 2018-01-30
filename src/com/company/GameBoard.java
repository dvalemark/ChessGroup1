package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private final int PAWN = 8;
    private final int WIDTH = 8;

    private Spot[][] spots;


    public GameBoard() {
        spots = new Spot[WIDTH][WIDTH];
        fillList();
        addPieces();
    }

    ///ADD 64 SPOTS
    private void fillList() {
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < WIDTH; x++) {
                spots[y][x] = new Spot();
            }
        }

    }

    ///ADD PIECES TO CORRECT SLOTS
    public void addPieces() {
        ////ADD WHITE PIECES///////////
        spots[0][5].setPiece(new Piece(Kind.KING, Color.WHITE));
        for (int i = 0; i < PAWN; i++) {
            spots[1][i].setPiece(new Piece(Kind.PAWN, Color.WHITE));
        }
        ////ADD BLACK PIECES///////////
        spots[7][5].setPiece(new Piece(Kind.KING, Color.BLACK));
        for (int i = 0; i < PAWN; i++) {
            spots[6][i].setPiece(new Piece(Kind.PAWN, Color.BLACK));
        }
    }

    public void printSpots() {
        System.out.println("SHOWS WHICH SPOTS ARE OCCUPIED WITH PIECES:");
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (spots[y][x].getPiece() != null) {
                    System.out.println(y + ":" + x + " " + spots[y][x].getPiece().color + " " + spots[y][x].getPiece().kind);
                    {
                    }
                } else {
                    System.out.println(y + ":" + x + " " + "EMPTY");
                }
            }
        }
    }

}
