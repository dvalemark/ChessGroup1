package com.company;


import java.util.HashMap;
import java.util.Map;

public class Game {
    GameBoard gameBoard = new GameBoard();
    Render render = new Render();
    MoveHelper moveHelper = new MoveHelper();

    public void run() throws InterruptedException {

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
