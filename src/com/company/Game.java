package com.company;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Game {
    GameBoard gameBoard = new GameBoard();
    Render render = new Render();
    MoveHelper moveHelper = new MoveHelper();
    Color color = Color.WHITE;

    public void run() throws InterruptedException {
        Thread.sleep(500);
        render.updatePieces();
        render.nextMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveHelper.analyzeMoves(color);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                render.updatePieces();
                if(color == Color.WHITE){
                    color = Color.BLACK;
                }else{
                    color = color.WHITE;

                }

            }
        });


    }

}
