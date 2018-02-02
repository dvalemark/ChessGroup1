package sample;

public class MoveHelper {
    private Spot[][] spots = GameBoard.spots;


    public Piece isForwardLeft(int y, int x, int range, int direction) {
        return spots[y - range * direction][x - range].getPiece();
    }

    public Piece isForwardRight(int y, int x, int range, int direction) {
        return spots[y + range * direction][x + range].getPiece();
    }

    public Piece isForward(int y, int x, int range, int direction) {
        return spots[y + (range * direction)][x].getPiece();
    }
}
