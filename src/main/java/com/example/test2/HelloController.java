package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    static String realusername = "sudeep";
    static String realpassword = "Timalsina";

    @FXML
    public TextField username;  // Ensure this is defined as @FXML
    @FXML
    public PasswordField password; // Ensure this is defined as @FXML
    @FXML
    public Label msg; // Corrected to Label type

    @FXML
    public void handleLoginAction(ActionEvent actionEvent) {
        String usernameinput = username.getText(); // Get the username input
        String passwordinput = password.getText(); // Get the password input

        if (usernameinput.equals(realusername) && passwordinput.equals(realpassword)) {
            try {
                Parent secondScene = FXMLLoader.load(getClass().getResource("view-board.fxml"));
                Stage secondStage = new Stage();
                secondStage.setTitle("User Scene");
                secondStage.setScene(new Scene(secondScene));

                // Close the current stage
                Stage firstSceneStage = (Stage) msg.getScene().getWindow();
                firstSceneStage.close();

                secondStage.show();
            } catch (IOException e) {
                msg.setText("Error loading the user scene.");
                e.printStackTrace();
            }
        } else {
            msg.setText("Incorrect username or password."); // Updated message for clarity
        }
    }

    @FXML
    public void logoutClick(ActionEvent actionEvent) {
        try {
            Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Parent loginScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(loginScene));
            currentStage.close();
            loginStage.show();
        } catch (IOException e) {
            msg.setText("Error loading the login scene."); // Updated message for clarity
            e.printStackTrace();
        }
    }

    public void gotoCRUD(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("user-view.fxml"));
            Stage secondStage = new Stage();
            secondStage.setTitle("CRUD Operations");
            secondStage.setScene(new Scene(secondScene));
            secondStage.show();
        } catch (IOException e) {
            msg.setText("Error loading the CRUD operations scene."); // Updated message for clarity
            e.printStackTrace();
        }
    }
}
