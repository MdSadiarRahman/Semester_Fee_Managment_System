package furyproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PopupWindow {

    private Stage stage;
    private String message;

    public PopupWindow(Stage ownerStage, String message) {
        stage = new Stage();
        this.message = message;
        VBox vbox = new VBox(20);
        setupUI(vbox);
    }

    private void setupUI(VBox vbox) {
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Label msgLabel = new Label(message);
        msgLabel.setFont(new javafx.scene.text.Font("Segoe UI", 16));

        Button okButton = new Button("OK");
        okButton.setPrefWidth(80);
        okButton.setOnAction(e -> stage.close());

        vbox.getChildren().addAll(msgLabel, okButton);
    }

    public void show() {
        Scene popupScene = new Scene(new VBox(20), 280, 130);
        stage.setScene(popupScene);
        stage.setTitle("Notification");
        stage.showAndWait();
    }
}