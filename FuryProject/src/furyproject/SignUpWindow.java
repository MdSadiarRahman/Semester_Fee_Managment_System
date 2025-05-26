package furyproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;
import javafx.scene.paint.Stop;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SignUpWindow {

    private Stage stage;
    private StackPane rightPane; // Right pane for layout

    // Constructor to initialize the SignUpWindow with necessary parameters
    public SignUpWindow(Stage primaryStage, StackPane rightPane) {
        this.stage = primaryStage;
        this.rightPane = rightPane;
        setupUI();  // Call to setup the UI
    }

    private void setupUI() {
        VBox formBox = new VBox();  // Create a new VBox for this window
        formBox.setPadding(new Insets(50, 40, 40, 40));
        formBox.setAlignment(Pos.TOP_CENTER);
        formBox.setSpacing(20);

        // Group icon
        Label groupIcon = new Label("\uD83D\uDC65");
        groupIcon.setFont(Font.font(48));
        groupIcon.setTextFill(Color.web("#4A8BD9"));

        Label signUpLabel = new Label("Sign Up");
        signUpLabel.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 22));
        signUpLabel.setTextFill(Color.web("#4A8BD9"));
        VBox.setMargin(signUpLabel, new Insets(0, 0, 15, 0));

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-prompt-text-fill: #4A8BD9; " +
                "-fx-border-color: transparent transparent #4A8BD9 transparent; -fx-border-width: 0 0 1.8 0;");
        usernameField.setPrefHeight(35);

        Label userIcon = new Label("\uD83D\uDC64");
        userIcon.setTextFill(Color.web("#4A8BD9"));
        userIcon.setFont(Font.font(18));
        HBox usernameBox = new HBox(10, userIcon, usernameField);
        usernameBox.setAlignment(Pos.CENTER_LEFT);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-prompt-text-fill: #4A8BD9; " +
                "-fx-border-color: transparent transparent #4A8BD9 transparent; -fx-border-width: 0 0 1.8 0;");
        passwordField.setPrefHeight(35);

        Label lockIcon = new Label("\uD83D\uDD12");
        lockIcon.setTextFill(Color.web("#4A8BD9"));
        lockIcon.setFont(Font.font(18));
        HBox passwordBox = new HBox(10, lockIcon, passwordField);
        passwordBox.setAlignment(Pos.CENTER_LEFT);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        confirmPasswordField.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-prompt-text-fill: #4A8BD9; " +
                "-fx-border-color: transparent transparent #4A8BD9 transparent; -fx-border-width: 0 0 1.8 0;");
        confirmPasswordField.setPrefHeight(35);

        Label confirmLockIcon = new Label("\uD83D\uDD12");
        confirmLockIcon.setTextFill(Color.web("#4A8BD9"));
        confirmLockIcon.setFont(Font.font(18));
        HBox confirmPasswordBox = new HBox(10, confirmLockIcon, confirmPasswordField);
        confirmPasswordBox.setAlignment(Pos.CENTER_LEFT);

        VBox fieldsBox = new VBox(20, usernameBox, passwordBox, confirmPasswordBox);
        fieldsBox.setAlignment(Pos.CENTER);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setPrefWidth(140);
        signUpButton.setPrefHeight(40);
        signUpButton.setStyle("-fx-background-color: #3E74E2; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        signUpButton.setOnAction(e -> showPopup("Successfully Signed Up"));

        Label alreadyAccountLabel = new Label("Already have account?");
        alreadyAccountLabel.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 13));
        alreadyAccountLabel.setTextFill(Color.web("#4A8BD9"));
        alreadyAccountLabel.setCursor(Cursor.HAND);
        alreadyAccountLabel.setOnMouseClicked(e -> showSignIn());
        VBox.setMargin(alreadyAccountLabel, new Insets(10, 0, 0, 0));

        formBox.getChildren().addAll(groupIcon, signUpLabel, fieldsBox, signUpButton, alreadyAccountLabel);

        // Set up background gradient for the right pane
        Stop[] stopsRight = new Stop[]{
                new Stop(0, Color.web("#1C3144")),
                new Stop(1, Color.web("#304E68"))
        };
        LinearGradient lgRight = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stopsRight);
        rightPane.setBackground(new Background(new BackgroundFill(lgRight, new CornerRadii(0, 30, 30, 0, false), Insets.EMPTY)));

        // Set the right pane's content
        rightPane.getChildren().clear();
        rightPane.getChildren().add(formBox);
    }

    // Method to show a popup window (success message)
    private void showPopup(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Show the sign-up window
    public void show() {
        setupUI();  // Make sure to call setupUI before showing the window
        Scene scene = new Scene(rightPane, 400, 350);
        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.show();
    }

    // Implement the logic for showing the sign-in window
    private void showSignIn() {
        // Logic to navigate to the sign-in screen
    }
}