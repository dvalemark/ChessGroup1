package sample;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class Render {

    public static final int TILE_SIZE = 50;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private static Tile [][] board = new Tile[WIDTH][HEIGHT];

    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();
    //Pieces underneath

     Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(WIDTH*TILE_SIZE, HEIGHT*TILE_SIZE);
        root.getChildren().addAll(tileGroup);

        for (int y = 0; y <HEIGHT ; y++) {
            for (int x = 0; x <WIDTH ; x++) {
                board[x][y]= piece;
                piece = null;
                Tile tile = new Tile((x+y)%2==0,x,y);
                tileGroup.getChildren().add(tile);

            }
        }
       pieceGroup.getChildren().add(piece);

        return root;
    }

    //  public Piece makePiece (Piecetype type, int x, int y){
    //      Piece piece = new Piece(type, x, y);

    //}
}
