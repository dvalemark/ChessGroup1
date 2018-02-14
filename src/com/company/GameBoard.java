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
        tile[0][0].setPiece(new Rook(Color.BLACK));
        tile[0][7].setPiece(new Rook(Color.BLACK));
        tile[0][2].setPiece(new Bishop(Color.BLACK));
        tile[0][5].setPiece(new Bishop(Color.BLACK));

        ////ADD WHITE PIECES///////////
        tile[7][4].setPiece(new King(Color.WHITE));

        for (int i = 0; i < PAWN; i++) {
            tile[6][i].setPiece(new Pawn(Color.WHITE));
        }
        tile[7][0].setPiece(new Rook(Color.WHITE));
        tile[7][7].setPiece(new Rook(Color.WHITE));
        tile[7][2].setPiece(new Bishop(Color.WHITE));
        tile[7][5].setPiece(new Bishop(Color.WHITE));
    }

    ///MOVE ONE PIECE


}
