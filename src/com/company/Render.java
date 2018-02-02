package com.company;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;


public class Render extends JPanel{
    final static int WIDTH = 8;
    final static int HEIGHT = 8;
    JFrame frame = new JFrame("CHESS");

    public void paint(Graphics g){
        g.fillRect(100, 100, 400, 400);
        for(int i = 100; i <= 400; i+=100){
            for(int j = 100; j <= 400; j+=100){
                g.clearRect(i, j, 50, 50);
            }
        }

        for(int i = 150; i <= 450; i+=100){
            for(int j = 150; j <= 450; j+=100){
                g.clearRect(i, j, 50, 50);
            }
        }
    }
    public void drawBoard(){
        frame.setSize(800,800);
       // frame.getContentPane().add(new Render());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void renderPieces(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (GameBoard.spots[y][x].getPiece() != null) {
                    Piece piece = GameBoard.spots[y][x].getPiece();
                    JLabel label = new JLabel(piece.kind.toString().charAt(0)+" "+piece.getColor());
                    label.setBounds(x*100,y*100,50,50);
                    frame.add(label);
                    }
                }
            }

        }


    }



