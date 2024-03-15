package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 275);
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        stage.setTitle("Genshin Impact Trainer");

        HelloController.users = new HashMap<>();
        HelloController.users.put("hunyo", "123");
        HelloController.users.put("jian", "456");
        HelloController.users.put("van", "789");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}