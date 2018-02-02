package sample;

public class Spot {

    private Piece piece;

    public Spot() {
        this.piece = null;
    }

    public Spot(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }
}
