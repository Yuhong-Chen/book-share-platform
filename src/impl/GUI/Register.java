package impl.GUI;

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
                // Registering a user code goes here.
            }
        });

        mainCol.getChildren().add(signUp);
        mainCol.getStyleClass().addAll("container", "middle");

        //Renders what the user will see
        Scene myPage = new Scene(mainCol, 720, 480);
        myPage.getStylesheets().addAll(Register.class.getResource("/css/Sitewide.css").toExternalForm());

        return myPage;
    }
}
