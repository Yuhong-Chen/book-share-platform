package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox myPane = new VBox();
        myPane.setStyle("-fx-background-color:WHITE;-fx-padding:40;-fx-font-size:24");
        myPane.setSpacing(30);

        Scene scene = new Scene(myPane, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Log into your Account");
        stage.show();
    }
}
