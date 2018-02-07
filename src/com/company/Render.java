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
    JPanel panel;
    ArrayList<JLabel> labelList;

    public Render() {
        gui();
        System.out.println("BOARD CREATED");
    }


    public void updatePieces() {
        panel.removeAll();
        labelList.clear();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {

                if (GameBoard.tile[y][x].getPiece() != null) {
                    Piece piece = GameBoard.tile[y][x].getPiece();

                        JButton button = new JButton();
                        button.setIcon(new ImageIcon(piece.imagePath));
                        button.setBounds(x * 100, y * 100, 90, 90);
                        panel.add(button);
                    }
                }
            }
        /*
        for(JLabel label: labelList){
            panel.add(label);
            panel.revalidate();
        }
        */
            panel.revalidate();
            panel.repaint();
            frame.revalidate();
            frame.repaint();
        }


        public void gui () {
            labelList = new ArrayList<>();
            frame = new JFrame("CHESS");
            frame.setSize(800, 800);
            //frame.getContentPane().add(new Render());
            frame.setLocationRelativeTo(null);
            frame.setBackground(Color.LIGHT_GRAY);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            panel = new JPanel();
            panel.setBackground(new Color(0, 0, 0, 0));
            panel.setLayout(null);
            frame.add(panel);
        }
    }
