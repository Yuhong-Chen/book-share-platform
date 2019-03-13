package impl.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Register extends Application {

    @Override
    public void start(Stage myStage) {
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
                // Registering a user code goes here.
            }
        });

        mainCol.getChildren().add(signUp);

        //Renders what the user will see
        Scene viewport = new Scene(mainCol, 720, 480);

        mainCol.getStyleClass().addAll("container", "middle");

        viewport.getStylesheets().addAll(Register.class.getResource("/css/Sitewide.css").toExternalForm());

        myStage.setScene(viewport);
        myStage.setTitle("Register for an account");
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
