package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Render render = new Render();
       Scene scene = new Scene(render.createContent());
       primaryStage.setTitle("Chess");
       primaryStage.setScene(scene);
       primaryStage.show();
    }



    public static void main(String[] args) {

        launch(args);
    }
}