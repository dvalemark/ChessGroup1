package com.company;


import java.util.HashMap;
import java.util.Map;

public class Game {
    Render render = new Render();

    public void run() throws InterruptedException {
        GameBoard gameBoard = new GameBoard();
        render.drawBoard();
        render.renderPieces();

        /*
        while (true) {
            render.renderPieces();
            Thread.sleep(3000);
            gameBoard.analyzeMoves(Color.WHITE);
            render.renderPieces();                  ////LOGICS ARE WORKING THE COMPUTER MOVES BUT THE RENDER UPDATE ON SCREEN IS HORRIBLE
            Thread.sleep(3000);
            gameBoard.analyzeMoves(Color.BLACK);
            render.renderPieces();
        }
        */
   }

}
