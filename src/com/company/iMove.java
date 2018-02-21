package com.company;

import java.util.ArrayList;

public interface iMove {
    boolean checkMove(int y, int toY, int x, int toX, Piece possiblePiece);

    ArrayList<Move> listPossibleMoves(int y, int x);
}
