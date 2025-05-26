package furyproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FeeManagementLoginUI extends Application {

    private StackPane rightPane;
    private Stage primaryStage;

    // Enum to define different sign-in modes (Admin or Student)
    public enum SignInMode {
        DEFAULT, ADMIN, STUDENT
    }

    private SignInMode currentSignInMode = SignInMode.DEFAULT;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Setting up the main layout (HBox with two parts)
        HBox root = new HBox();
        root.setPrefSize(700, 500);

        // Left pane setup (e.g., logo or text)
        StackPane leftPane = createLeftPane();  // Now correctly calling the method
        rightPane = new StackPane();
        rightPane.setPrefWidth(350);

        root.getChildren().addAll(leftPane, rightPane);

        // Create the scene and set it in the primary stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fee Management System");
        primaryStage.setResizable(false);
        primaryStage.show();

        // Default to showing the sign-up window (can be changed based on logic)
        showSignUp();
    }

    // This is the 'createLeftPane' method definition, which was missing
    private StackPane createLeftPane() {
        StackPane leftPane = new StackPane();
        leftPane.setPrefWidth(350);

        // Adding a gradient background
        Stop[] stopsLeft = new Stop[]{
                new Stop(0, Color.web("#0F2027")),
                new Stop(1, Color.web("#203A43"))
        };
        LinearGradient lgLeft = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stopsLeft);
        leftPane.setBackground(new Background(new BackgroundFill(lgLeft, CornerRadii.EMPTY, Insets.EMPTY)));

        // Adding text and effects
        DropShadow blueGlowLarge = new DropShadow();
        blueGlowLarge.setColor(Color.web("#3163b5", 0.9));
        blueGlowLarge.setBlurType(BlurType.GAUSSIAN);
        blueGlowLarge.setRadius(50);
        blueGlowLarge.setSpread(0.4);

        DropShadow blueGlowSmall = new DropShadow();
        blueGlowSmall.setColor(Color.web("#3163b5", 0.8));
        blueGlowSmall.setBlurType(BlurType.GAUSSIAN);
        blueGlowSmall.setRadius(25);
        blueGlowSmall.setSpread(0.3);

        Color textColor = Color.web("#141e30");

        Text letterF = new Text("F");
        letterF.setFont(Font.font("Script MT Bold", FontWeight.BOLD, 150));
        letterF.setFill(textColor);
        letterF.setOpacity(0.95);
        letterF.setEffect(blueGlowLarge);

        Text systemText = new Text("Fee Management System");
        systemText.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, 28));
        systemText.setFill(textColor);
        systemText.setTranslateY(90);
        systemText.setEffect(blueGlowSmall);

        // Creating the background glow effect
        Region glowBg = new Region();
        glowBg.setPrefSize(320, 220);
        glowBg.setBackground(new Background(new BackgroundFill(Color.web("#1C3144", 0.7), new CornerRadii(40), Insets.EMPTY)));
        glowBg.setEffect(new DropShadow(70, Color.web("#304E68", 0.9)));

        StackPane textGroup = new StackPane(glowBg, letterF, systemText);
        StackPane.setAlignment(systemText, Pos.CENTER);
        StackPane.setMargin(systemText, new Insets(90, 0, 0, 0));

        leftPane.getChildren().add(textGroup);

        return leftPane;
    }

    // Method to show the sign-in window (either Admin or Student)
    private void showSignIn(SignInMode mode) {
        currentSignInMode = mode;
        SignInWindow signInWindow = new SignInWindow(primaryStage, mode, rightPane); // Passing correct enum value here
        signInWindow.show();
    }

    // Method to show the sign-up window
    private void showSignUp() {
        SignUpWindow signUpWindow = new SignUpWindow(primaryStage, rightPane);  // Pass parameters to the constructor
        signUpWindow.show();
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}