package com.company;


import java.util.HashMap;
import java.util.Map;

public class Game {
    Render render = new Render();

    public void run() {
        GameBoard gameBoard = new GameBoard();
        render.drawBoard();
        gameBoard.makeMove(new Move(0,6,4,4,4));
        render.renderPieces();

    }
}
