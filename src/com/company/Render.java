package com.company;

import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.*;
import javax.swing.border.Border;


public class Render extends JFrame {
    final static int WIDTH = 8;
    final static int HEIGHT = 8;
    JFrame frame;
    Board panel = new Board();

    public Render() {
        gui();
        System.out.println("BOARD CREATED");
    }


    public void updatePieces() {
        panel.removeAll();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (GameBoard.tile[y][x].getPiece() != null) {
                    Piece piece = GameBoard.tile[y][x].getPiece();
                    JButton button = new JButton();
                    button.setIcon(new ImageIcon(piece.imagePath));
                    button.setBounds(x * 75, y * 75, 75, 75);
                    button.setOpaque(false);
                    button.setContentAreaFilled(false);
                    button.setBorderPainted(false);
                    panel.add(button);
                }
            }
        }

        panel.revalidate();
        panel.repaint();
        frame.revalidate();
        frame.repaint();
    }


    public void gui() {
        frame = new JFrame("CHESS");
        frame.setSize(620, 650);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        panel.setLayout(null);
        frame.add(panel);
    }
}
