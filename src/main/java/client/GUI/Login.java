package client.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import client.Requests.Users;

class Login {

    static Scene buildPage() {
        VBox myPane = new VBox();

        myPane.setSpacing(30);

        myPane.getChildren().add(UIComponents.genSiteTitle());

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

        myPane.getStyleClass().add("container");

        Scene myPage = new Scene(myPane, 720, 480);

        myPage.getStylesheets()
            .addAll(Login.class.getResource("/css/Sitewide.css").toExternalForm(),
                    Login.class.getResource("/css/LoginScreen.css").toExternalForm());

        return myPage;
    }
}
