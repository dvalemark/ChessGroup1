package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Render extends JPanel {

    public void paint(Graphics g) {

        g.fillRect(100, 100, 400, 400);
        for (int i = 100; i <= 400; i += 100) {
            for (int j = 100; j <= 400; j += 100) {
                g.clearRect(i, j, 50, 50);

            }

        }

        for (int i = 150; i <= 450; i += 100) {
            for (int j = 150; j <= 450; j += 100) {
                g.clearRect(i, j, 50, 50);

            }

        }
    }


}

