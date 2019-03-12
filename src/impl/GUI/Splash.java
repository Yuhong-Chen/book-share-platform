package impl.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Splash extends Application {

    @Override
    public void start(Stage myStage) {
        VBox mainBox = new VBox();

        Scene splashScene = new Scene(mainBox, 720, 480);
        splashScene.getStylesheets().addAll(Splash.class.getResource("/css/Sitewide.css").toExternalForm());

        myStage.setScene(splashScene);
        myStage.setTitle("Welcome to BookyBooks!");
        myStage.show();
    }

    public static void main(String[] myArgs) {
        launch(myArgs);
    }

}
