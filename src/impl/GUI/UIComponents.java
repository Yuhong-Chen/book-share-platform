package impl.GUI;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;

public class UIComponents {

    /**
     * Creates the label referring to the title of the site.
     * */
    static Label genSiteTitle() {
        Label siteTitle = new Label("BookyBooks");
        siteTitle.getStyleClass().add("title");

        return siteTitle;
    }

    /**
     * Generates a text field suitable for a user to enter their username.
     * */
    static JFXTextField genUsernameField() {
        JFXTextField usernameInput = new JFXTextField();
        usernameInput.setLabelFloat(true);
        usernameInput.setPromptText("Enter your username");
        usernameInput.getStyleClass().add("text-field");

        Helpers.makeNodeRequired(usernameInput, "You must enter a username");

        return usernameInput;
    }

    /**
     * Generates a text field suitable for password input.
     * */
    static JFXPasswordField genPasswordField(String prompt) {
        JFXPasswordField passwordInput = new JFXPasswordField();
        passwordInput.setLabelFloat(true);
        passwordInput.setPromptText(prompt);
        passwordInput.getStyleClass().add("text-field");

        Helpers.makeNodeRequired(passwordInput, "You must specify a password");

        return passwordInput;
    }
}
