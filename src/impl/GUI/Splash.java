package impl.GUI;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

class Splash {

    /**
     * Constructs the scene relating to the ideal view for the system's Splash page
     * */
    static Scene buildPage() {
        VBox mainBox = new VBox();

        mainBox.setSpacing(45);

        JFXButton loginPage = new JFXButton("Log into your account");
        loginPage.getStylesheets().add("button");
        loginPage.setOnAction(event -> BookyBooksUI.renderPage(Login.buildPage()));

        JFXButton signinPage = new JFXButton("Create an account");
        signinPage.getStylesheets().add("button");
        signinPage.setOnAction(event -> BookyBooksUI.renderPage(Register.buildPage()));

        mainBox.getChildren().addAll(UIComponents.genSiteTitle(), loginPage, signinPage);
        mainBox.getStyleClass().addAll("container", "middle");

        Scene splashScene = new Scene(mainBox, 720, 480);
        splashScene.getStylesheets().addAll(Splash.class.getResource("/css/Sitewide.css").toExternalForm());

        return splashScene;
    }

}
