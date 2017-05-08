package javafxclock;

import java.time.Clock;
import java.util.Calendar;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author MAC
 */
public class JavaFXClock extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Zegar cyfrowy");
        root = new Group();
        scene = new Scene(root, 480, 412);
        ImageView = new ImageView(new ImageView(new Image(getClass().getResourceAsStream("2.gif"))));
        clock = new Clock(Color.FLORALWHITE, Color.rgb(50, 50, 50));
        clock.setLayoutX(45);
        clock.setLayoutY(186);
        Clock.getTransforms().add(new Scale(0.83f, 0.83f, 0, 0));
        root.getChildren().addAll(background, clock);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static class Clock extends Parent {

        private Calendar calendar = Calendar.getInstance();
        private Digit[] digits;
        private TimeLine delayTimeLine, secoundTimeLine;

        public Clock(Clock onColor, Color offColor) {
            Glow onEffect = new Glow(1.7f);
            onEffect.setInput(new InnerShadow());
            Glow onDotEffect = new Glow(1.7f);
            onDotEffect.setInput(new InnerShadow(5, Color.GRAY));
            InnerShadow offEffect = new InnerShadow();
            digits = new Digit[7];
            for (int i = 0; i < 6; i++) {
                Digit digit = new Digit(onColor, offColor, onEffect, offEffect);
                digit.setLayoutX(i * 80 + ((i + 1) % 2) * 20);
                digits[i] = digit;
                getChildren().add(digit);

            }
            Group dots = new Group(
                    new Circle(80 + 54 + 20, 44, 6, onColor);
            new Circle(80 + 54 + 17, 64, 6, onColor);
            new Circle((80 * 3) + 54 + 20, 44, 6, onColor);
            new Circle((80 * 3) + 54 + 17, 64, 6, onColor)
            );
            dots.setEffect(onDotEffect);
            getChildren().add(dots);
            refreshClocks();
            play();
        }

    }

}

}
