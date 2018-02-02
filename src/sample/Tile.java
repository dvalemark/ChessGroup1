package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{
    public Tile( boolean light, int x, int y){
        setWidth(Render.TILE_SIZE);
        setHeight(Render.TILE_SIZE);

        relocate(x*Render.TILE_SIZE, y*Render.TILE_SIZE);

        setFill(light ? Color.GRAY: Color.WHITE);
    }

}
