package impl.GUI;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Splash extends Application {

    @Override
    public void start(Stage myStage) {
        VBox mainBox = new VBox();

        mainBox.setSpacing(45);

        JFXButton loginPage = new JFXButton("Log into your account");
        loginPage.getStylesheets().add("button");
        loginPage.setOnAction(event -> Application.launch(Login.class));

        JFXButton signinPage = new JFXButton("Create an account");
        signinPage.getStylesheets().add("button");
        signinPage.setOnAction(event -> Application.launch(Register.class));

        mainBox.getChildren().addAll(UIComponents.genSiteTitle(), loginPage, signinPage);
        mainBox.getStyleClass().addAll("container", "middle");

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
