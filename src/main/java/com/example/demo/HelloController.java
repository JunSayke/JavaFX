package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.HashMap;

public class HelloController {
    public TextField tfUsername;
    public PasswordField pfPassword;
    public Button btnSignIn;
    public Label tfFeedback;
    public Button btnLogout;
    public VBox pnLogIn;
    public AnchorPane pnLogout;
    public ColorPicker cpColorPicker;
    public static String color = "#ffffff";
    public static HashMap<String, String> users;

    @FXML
    protected void onSignInButtonClick() throws IOException {
        String username = tfUsername.getText().toString();
        String password = pfPassword.getText().toString();

        if (username.isEmpty()) {
            tfFeedback.setText("Username must not be empty!");
            return;
        }

        if (password.isEmpty()) {
            tfFeedback.setText("Password must not be empty!");
            return;
        }

        if (!users.containsKey(username)) {
            tfFeedback.setText("Username does not exist!");
            return;
        }

        if (!users.get(username).equals(password)) {
            tfFeedback.setText("Incorrect password!");
            return;
        }

        AnchorPane p = (AnchorPane) pnLogIn.getParent();
        Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);

        ((AnchorPane) p.getChildren().get(0)).getChildren().get(0).setStyle("-fx-background-color: " + color + ";");
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        color = "#" + cpColorPicker.getValue().toString().substring(2, 8);
        AnchorPane p = (AnchorPane) pnLogout.getParent();
        Parent scene = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}