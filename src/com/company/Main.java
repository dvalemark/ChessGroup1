package com.company;


import javax.swing.*;
import java.awt.Color;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new com.company.Render());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        game.run();
    }

}
