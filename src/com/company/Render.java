package com.company;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;


public class Render extends JPanel {
    final static int WIDTH = 8;
    final static int HEIGHT = 8;
    JFrame frame;
    JPanel panel;

    public Render() {
        gui();
    }

    public void paint(Graphics g) {
    }

    public void updatePieces(){
        panel.removeAll();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (GameBoard.spots[y][x].getPiece() != null) {
                    Piece piece = GameBoard.spots[y][x].getPiece();
                    JLabel label = new JLabel(piece.unicode);
                    label.setBounds(x*100,y*100,100,100);
                    panel.add(label);
                    panel.repaint();
                }
            }
        }

    }

    public void gui() {
        frame = new JFrame("CHESS");
        frame.setSize(800, 800);
         //frame.getContentPane().add(new Render());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frame.add(panel);
    }
}




