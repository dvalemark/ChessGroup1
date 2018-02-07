package com.company;


import java.util.HashMap;
import java.util.Map;

public class Game {
    Render render = new Render();

    public void run() throws InterruptedException {
        GameBoard gameBoard = new GameBoard();
        Thread.sleep(1000);
        render.updatePieces();

        while (true) {
            render.updatePieces();
            Thread.sleep(1000);
            gameBoard.analyzeMoves(Color.WHITE);
            render.updatePieces();
            Thread.sleep(1000);
            gameBoard.analyzeMoves(Color.BLACK);
            render.updatePieces();
        }

   }

}
