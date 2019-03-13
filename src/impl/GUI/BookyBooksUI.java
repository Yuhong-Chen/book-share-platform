package impl.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookyBooksUI extends Application {

    private static Scene currentPage;
    private static Stage primaryStage;

    @Override
    public void start(Stage myStage) {
        primaryStage = myStage;
        renderPage(currentPage);
    }

    static void setCurrentPage(Scene newPage) {
        currentPage = newPage;
    }

    static void renderPage(Scene myPage) {
        primaryStage.setScene(myPage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        setCurrentPage(Splash.buildPage());

        launch(args);
    }
}
