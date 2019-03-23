package client.GUI;

import client.controller.Request;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

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

        //Send login request
        button.setOnAction(event -> {
            Request request = new Request("user/" + username.getText());
            JsonObject response = request.get();

            if (response != null) {
                String pass = response.get("userPwd").getAsString();
                System.out.println(pass);
                if (pass.equals(password.getText())) {
                    //do something
                    System.out.println("log in works");
                }
                //else incorrect pass
                System.out.println("Incorrect password");
            }
            //else error
            System.out.println("Error during request");
        });
        //·

        myPane.getStyleClass().add("container");

        Scene myPage = new Scene(myPane, 720, 480);

        myPage.getStylesheets()
            .addAll(Login.class.getResource("/css/Sitewide.css").toExternalForm(),
                    Login.class.getResource("/css/LoginScreen.css").toExternalForm());

        return myPage;
    }
}
