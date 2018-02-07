package com.company;


import java.util.HashMap;
import java.util.Map;

public class Game {
    Render render = new Render();

    public void run() throws InterruptedException {
        GameBoard gameBoard = new GameBoard();
        MoveHelper moveHelper = new MoveHelper();
        Thread.sleep(1000);
        render.updatePieces();

        while (true) {
            render.updatePieces();
            Thread.sleep(3000);
            moveHelper.analyzeMoves(Color.WHITE);
            render.updatePieces();
            Thread.sleep(3000);
            moveHelper.analyzeMoves(Color.BLACK);
            render.updatePieces();
        }

    }

}
