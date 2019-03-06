package impl.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.base.IFXLabelFloatControl;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import impl.GUI.Helpers;
import impl.Requests.Users;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane infoPane = new StackPane();
        VBox myPane = new VBox();

        myPane.setStyle("-fx-background-color:#DDDDDD;-fx-padding:40;-fx-font-size:24");
        myPane.setSpacing(30);

        Label siteTitle = new Label("BookyBooks");
        siteTitle.getStyleClass().add("title");
        myPane.getChildren().add(siteTitle);

        JFXTextField username = new JFXTextField();
        username.setLabelFloat(true);
        username.setPromptText("Enter your username");
        username.getStyleClass().add("text-field");

        Helpers.makeNodeRequired(username, "You must enter a username.");

        myPane.getChildren().add(username);

        JFXPasswordField password = new JFXPasswordField();
        password.setLabelFloat(false);
        password.setPromptText("Enter your password");
        password.getStyleClass().add("text-field");

        Helpers.makeNodeRequired(password, "You must enter a password.");

        myPane.getChildren().add(password);

        JFXButton button = new JFXButton("Log In");
        button.getStyleClass().add("login-button");
        myPane.getChildren().add(button);

        button.setOnAction((event -> {
            if (username.validate() && password.validate())
                Users.execLogin(username.getText(), password.getText());
        }));
        //·

        myPane.getChildren().add(infoPane);
        myPane.getStyleClass().add("container");

        Scene scene = new Scene(myPane, 720, 480);

        scene.getStylesheets()
            .addAll(Login.class.getResource("/css/Sitewide.css").toExternalForm(),
                    Login.class.getResource("/css/LoginScreen.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Log into your Account");
        stage.show();
    }
}
