package cl.adumun.academiclabs.dsy1102.estacionsur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cl/adumun/academiclabs/dsy1102/estacionsur/main-view.fxml"));
        Scene scene = new Scene(loader.load(), 980, 620);

        stage.setTitle("Centro Cultural Estación Sur — Administración");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}