package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Board extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image;
        try {
            image = ImageIO.read(getClass().getResource("/resources/images/background.png"));
            g.drawImage(image,0,0,this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
