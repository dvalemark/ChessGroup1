package com.company;


import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Gameboard gameboard = new Gameboard();
        Screen screen;
        screen = TerminalFacade.createScreen();
        screen.startScreen();
        gameboard.drawSquares(screen);
    }
}
