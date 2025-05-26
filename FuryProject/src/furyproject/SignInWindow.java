package furyproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Stop;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// Import SignInMode from FeeManagementLoginUI
import furyproject.FeeManagementLoginUI.SignInMode;

public class SignInWindow {

    private final Stage stage;
    private final SignInMode mode;
    private final StackPane rightPane;

    // Constructor to initialize the SignInWindow with necessary parameters
    public SignInWindow(Stage primaryStage, SignInMode mode, StackPane rightPane) {
        this.stage = primaryStage;
        this.mode = mode;
        this.rightPane = rightPane;
        setupUI();  // Set up the user interface after initialization
    }

    private void setupUI() {
        VBox formBox = new VBox();
        formBox.setPadding(new Insets(50, 40, 40, 40));
        formBox.setAlignment(Pos.TOP_CENTER);
        formBox.setSpacing(25);

        // Group icon
        Label groupIcon = new Label("\uD83D\uDC65");
        groupIcon.setFont(Font.font(48));
        groupIcon.setTextFill(Color.web("#4A8BD9"));

        // Set title text based on SignInMode
        String titleText = switch (mode) {
            case ADMIN -> "Admin Sign In";
            case STUDENT -> "Student Sign In";
            default -> "Sign In";
        };

        Label signInLabel = new Label(titleText);
        signInLabel.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 22));
        signInLabel.setTextFill(Color.web("#4A8BD9"));
        VBox.setMargin(signInLabel, new Insets(0, 0, 15, 0));

        // Username field with icon
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

        // Password field with icon
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

        VBox fieldsBox = new VBox(20, usernameBox, passwordBox);
        fieldsBox.setAlignment(Pos.CENTER);

        // Login button
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(140);
        loginButton.setPrefHeight(40);
        loginButton.setStyle("-fx-background-color: #3E74E2; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        loginButton.setOnAction(e -> showPopup(titleText + " successful"));

        // Back button
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #FF5C5C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        backButton.setPrefWidth(140);
        backButton.setOnAction(e -> showWelcomeWindow());

        // Create new account label (for navigation to sign-up)
        Label createAccountLabel = new Label("Create new account ?");
        createAccountLabel.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 13));
        createAccountLabel.setTextFill(Color.web("#4A8BD9"));
        createAccountLabel.setCursor(Cursor.HAND);
        createAccountLabel.setOnMouseClicked(e -> showSignUp());
        VBox.setMargin(createAccountLabel, new Insets(10, 0, 0, 0));

        // Adding components to formBox
        formBox.getChildren().clear();
        formBox.getChildren().addAll(groupIcon, signInLabel, fieldsBox, loginButton, backButton);

        // Add the create account label for DEFAULT mode
        if (mode == SignInMode.DEFAULT) {
            formBox.getChildren().add(createAccountLabel);
        }

        // Background gradient for right pane
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

    // Method to show the sign-in window
    public void show() {
        Scene scene = new Scene(new VBox(), 400, 350);
        stage.setScene(scene);
        stage.setTitle("Sign In");
        stage.show();
    }

    // Implement the logic for showing the welcome window
    private void showWelcomeWindow() {
        // Logic to return to the home or previous screen
    }

    // Implement the logic to navigate to the sign-up window
    private void showSignUp() {
        // Logic to navigate to the sign-up screen
    }
}