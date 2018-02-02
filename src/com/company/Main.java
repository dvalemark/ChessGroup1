package com.company;


import javax.swing.*;
import java.awt.Color;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
