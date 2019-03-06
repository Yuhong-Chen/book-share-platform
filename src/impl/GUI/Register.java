package impl.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Register extends Application {

    @Override
    public void start(Stage myStage) {
        //This will contain the majority of all the
        VBox mainCol = new VBox();

        //Renders what the user will see
        Scene viewport = new Scene(mainCol, 720, 480);
        myStage.setScene(viewport);
        myStage.setTitle("Register for an account");
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
