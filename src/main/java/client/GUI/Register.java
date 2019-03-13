package client.GUI;

import client.controller.Request;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

class Register {

    static Scene buildPage() {
        //This will contain the majority of all the UI elements, if not all
        VBox mainCol = new VBox();

        mainCol.setSpacing(30);

        mainCol.getChildren().add(UIComponents.genSiteTitle());

        JFXTextField usernameInput = UIComponents.genUsernameField();
        mainCol.getChildren().add(usernameInput);

        JFXPasswordField passwordInput = UIComponents.genPasswordField("Enter your desired password");
        mainCol.getChildren().add(passwordInput);

        JFXPasswordField passwordReentry = UIComponents.genPasswordField("Re-enter your chosen password", false);
        Helpers.ensureIdenticalValues(passwordInput, passwordReentry, "The entered passwords must be identical.");
        mainCol.getChildren().add(passwordReentry);

        JFXButton signUp = new JFXButton("Sign Up");
        signUp.getStylesheets().add("button");
        signUp.setOnAction(event -> {
            if (usernameInput.validate() && passwordInput.validate()
                && passwordInput.getText().equals(passwordReentry.getText())) {
                // Registering a User code goes here.
                JsonObject userData = new JsonObject();
                Request request = new Request("User/register");

                userData.addProperty("id", usernameInput.getText());
                userData.addProperty("userName", usernameInput.getText());
                userData.addProperty("userPwd", passwordInput.getText());

                int res = request.post(userData);
                System.out.println(res);
            }
        });

        mainCol.getChildren().add(signUp);
        mainCol.getStyleClass().addAll("container", "middle");

        //Renders what the User will see
        Scene myPage = new Scene(mainCol, 720, 480);
        myPage.getStylesheets().addAll(Register.class.getResource("/css/Sitewide.css").toExternalForm());

        return myPage;
    }
}
