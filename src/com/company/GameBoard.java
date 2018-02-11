package com.company;

public class GameBoard {
    private final int PAWN = 8;
    private final int WIDTH = 8;
    public static Tile[][] tile;

    public int getWIDTH() {
        return WIDTH;
    }

    GameBoard() {
        tile = new Tile[WIDTH][WIDTH];
        addEmptyTiles();
        addPieces();
    }


    ///ADD 64 empty tiles
    private void addEmptyTiles() {
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < WIDTH; x++) {
                tile[y][x] = new Tile();
            }
        }

    }

    ///ADD PIECES TO CORRECT SLOTS
    private void addPieces() {
        ////ADD BLACK PIECES///////////
        tile[0][4].setPiece(new King(Color.BLACK));
        for (int i = 0; i < PAWN; i++) {
            tile[1][i].setPiece(new Pawn(Color.BLACK));
        }
        ////ADD WHITE PIECES///////////
        tile[7][4].setPiece(new King(Color.WHITE));

        for (int i = 0; i < PAWN; i++) {
            tile[6][i].setPiece(new Pawn(Color.WHITE));
        }
        tile[3][4].setPiece(new Rook(Color.WHITE));
    }

    ///MOVE ONE PIECE


}
