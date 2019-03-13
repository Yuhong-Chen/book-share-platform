package impl.GUI;

import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.base.IFXLabelFloatControl;
import com.jfoenix.validation.RequiredFieldValidator;
import impl.model.Request;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane infoPane = new StackPane();
        VBox myPane = new VBox();

        myPane.setStyle("-fx-background-color:WHITE;-fx-padding:40;-fx-font-size:24");
        myPane.setSpacing(30);

        Label siteTitle = new Label("BookyBooks");
        siteTitle.getStyleClass().add("title");
        myPane.getChildren().add(siteTitle);

        JFXTextField username = new JFXTextField();
        username.setLabelFloat(true);
        username.setPromptText("Enter your username");
        username.getStyleClass().add("text-field");

        makeNodeRequired(username, "You must enter a username.");

        myPane.getChildren().add(username);

        JFXPasswordField password = new JFXPasswordField();
        password.setLabelFloat(false);
        password.setPromptText("Enter your password");
        password.getStyleClass().add("text-field");

        makeNodeRequired(password, "You must enter a password.");

        myPane.getChildren().add(password);

        JFXButton button = new JFXButton("Log In");
        button.getStyleClass().add("login-button");
        myPane.getChildren().add(button);

        //Send login request
        button.setOnAction(event -> {
            Request request = new Request("/login/" + username.getText());
            request.get();

        });
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

    /**
     * Turns any given JFX Node into one which is required before form submission.
     * The generic is constructed to ensure that only nodes which are capable of validation
     * can be used as a parameter.
     *
     * @param parentNode the node which is required
     * @param message the error message to show on the omission of a value for the {@param parentNode}
     * */
    private <N extends Node & IFXLabelFloatControl> void makeNodeRequired(N parentNode, String message) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage(message);

        parentNode.getValidators().add(validator);
        parentNode.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) parentNode.validate();
        });
    }
}
