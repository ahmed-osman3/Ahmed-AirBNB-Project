package com.example.airbnbproject2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {
private GUIController controller;
    @Override
    public void start(Stage stage) throws IOException {
        controller = new GUIController();
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("WelcomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}