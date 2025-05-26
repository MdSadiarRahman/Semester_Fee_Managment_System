package furyproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;

public class LeftPane extends StackPane {

    public LeftPane() {
        setPrefWidth(350);

        Stop[] stopsLeft = new Stop[]{
                new Stop(0, Color.web("#0F2027")),
                new Stop(1, Color.web("#203A43"))
        };
        LinearGradient lgLeft = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stopsLeft);
        setBackground(new Background(new BackgroundFill(lgLeft, CornerRadii.EMPTY, Insets.EMPTY)));

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

        Region glowBg = new Region();
        glowBg.setPrefSize(320, 220);
        glowBg.setBackground(new Background(new BackgroundFill(Color.web("#1C3144", 0.7), new CornerRadii(40), Insets.EMPTY)));
        glowBg.setEffect(new DropShadow(70, Color.web("#304E68", 0.9)));

        StackPane textGroup = new StackPane(glowBg, letterF, systemText);
        StackPane.setAlignment(systemText, Pos.CENTER);
        StackPane.setMargin(systemText, new Insets(90, 0, 0, 0));

        getChildren().add(textGroup);
    }
}