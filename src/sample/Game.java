package sample;


public class Game {


    public void run() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.makeMove(new Move(0, 6, 2, 6, 6));
        GameBoard.spots[2][6].getPiece().checkMoves(2, 6);
        GameBoard.spots[6][5].getPiece().checkMoves(6, 5);
    }
}
