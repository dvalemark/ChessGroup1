package com.company;

import com.googlecode.lanterna.terminal.Terminal;
import java.util.HashMap;
import java.util.Map;

public class Gameboard {
    private Map<Position,Piece> gameboard;

    public Gameboard(){
        this.gameboard = new HashMap<>();
        addSquares();
    }

    private void addSquares(){
        Color color;
        for (int y = 0; y < 8; y++) {
        for (int x = 0; x < 8 ; x++) {
                if(y%2==0){
                    if(x%2!=0) {
                        color = Color.WHITE;
                    }else {
                        color = Color.BLACK;
                    }
                }else{
                    if(x%2 == 0){
                        color = Color.WHITE;
                    }else {
                        color = Color.BLACK;
                    }
                }
            gameboard.put(new Position(x,y,color),null);
                }
        }
    }

    public void drawSquares(com.googlecode.lanterna.screen.Screen screen){
        String color;
        for (Map.Entry<Position, Piece> entry : gameboard.entrySet()) {
            if(entry.getKey().color == Color.WHITE){
                 color = "W";
            }else {
                color = "B";
            }
            screen.putString(entry.getKey().x, entry.getKey().y, color, Terminal.Color.WHITE, Terminal.Color.BLACK);
            System.out.println("X:" + entry.getKey().x + " Y:" + entry.getKey().y + " Color:" + entry.getKey().color);
        }
        screen.refresh();
        System.out.println(gameboard.entrySet());
    }

}
